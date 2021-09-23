package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinitionLeaftaps extends BaseClassLeaftaps {
	// public ChromeDriver driver; //First we declared in this class but now
	// declared in baseclassleaftaps and extended

	/*
	 * @Given("Launch the Chrome browser") //Commented out as it was implemented in
	 * HooksImplementation public void launchBrowser() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); }
	 * 
	 * @Given("Load the Leaftaps application url {string}") public void
	 * loadUrl(String url) { driver.get(url); }
	 */
//Methods for Create lead starts
	@Given("Input the username as {string}")
	public void inputUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Input the password as {string}")
	public void inputPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Hit the Login button")
	public void hitLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@When("Click the CRMSFA link")
	public void clickCRMLink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@When("Click the Leads link")
	public void clickLeadsLink() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@When("Click the CreateLead link")
	public void clickCreateLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@Then("Create lead page will be displayed")
	public void verifyCreateLeadPage() {
		String createleadpagetitle = driver.getTitle();
		System.out.println("Page title of Create lead page is " + createleadpagetitle);
		if (createleadpagetitle.equalsIgnoreCase("Create Lead | opentaps CRM")) {
			System.out.println("Create lead page is displayed");
		} else {
			System.out.println("Create lead page is not displayed");
		}
	}

	@Given("Input the Companyname as {string}")
	public void inputCompanyname(String companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}

	@Given("Input the Forename as {string}")
	public void inputForename(String forename) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(forename);
	}

	@Given("Input the Surname as {string}")
	public void inputSurname(String surname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(surname);
	}

	@When("Click the Createlead button")
	public void hitCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("ViewLead should be displayed")
	public void verifyNewLead() {
		String viewleadpagetitle = driver.getTitle();
		System.out.println("Page title of Create lead page is " + viewleadpagetitle);
		if (viewleadpagetitle.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("View Lead page is displayed");
		} else {
			System.out.println("View Lead page is not displayed");
		}
	}
//Methods for Edit Lead starts here
	@When("Click the FindLeads link")
	public void clickFindLeadsLink() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Click the Phone tab")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@When("Input the Phonenumber as {string}")
	public void inputPhoneno(String phoneno) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneno);
	}

	@When("Click the FindLeads button")
	public void clickFindLeadsButton() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}

	@When("Click the first resulting lead")
	public void clickFirstLead() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@When("Click the Edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("Edit the companyname as {string}")
	public void editCompanyName(String company) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
	}

	@When("Hit the Update button")
	public void hitUpdateButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Companyname of Lead should be updated")
	public void verifyCompanyname() {
		String companytext = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("The updated company name is " + companytext);
		if (!companytext.equalsIgnoreCase("TCS")) {
			System.out.println("Company name is updated");
		} else {
			System.out.println("Company name is not updated");
		}
	}
	
	//Method for Duplicate lead
	@When ("Click the DuplicateLead button")
	public void clickDuplicateButton() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	
	//Methods for Merge lead starts here
	@When ("Click the MergeLeads link")
	public void clickMergeLeadsLink() {
		driver.findElement(By.linkText("Merge Leads")).click();
	}
	@When ("Click the FromLead lookup {string}")
	public void clickFromLeadLookup(String fname) throws InterruptedException, IOException {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> allhandles1 = new ArrayList<String>(allWindows1);
		driver.switchTo().window(allhandles1.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String MergeleadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		FileOutputStream fos = new FileOutputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.setProperty("MergeLeadID", MergeleadID);
		prop.store(fos, null);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles1.get(0));
	}

	@When ("Click the ToLead lookup {string}")
	public void clickToLeadLookup(String lname) throws InterruptedException {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lname);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}
	
	@When ("Click the Merge button")
	public void clickMergeButton() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}
	
	@When ("Handle the alert")
	public void handleAlert() {

		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@When ("Search the LeadID")
	public void searchLeadID() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("MergeLeadID"));
	}
	
	@Then ("Verify the leads are merged")
	public void verifyLeadsMerged() {
		String text1 = driver.findElement(By.className("x-paging-info")).getText();
		if (text1.equals("No records to display")) {
			System.out.println("Text matched and leads are merged");
		} else {
			System.out.println("Text not matched and leads are not merged");
		}
	}
//Methods for Delete lead starting
	@When ("Click the first resulting lead to be deleted")
	public void fetchFirstResultingLead() throws IOException {
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		FileOutputStream fos = new FileOutputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.setProperty("leadID",leadID);
		prop.store(fos, null);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}
	
	@When ("Click the Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
		
	}
	@When ("Input the LeadID")
	public void inputLeadID() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(prop.getProperty("leadID"));
		
	}
	@When ("No search results should be displayed")
	public void verifyNoRecords() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		
	}
	
	
}
