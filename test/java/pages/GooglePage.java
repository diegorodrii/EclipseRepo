package pages;


public class GooglePage extends BasePage{

    private String searchButton = "//input[@value='Buscar con Google']";
    private String acceptCookies = "/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/button[2]/div";
    private String searchFieldText = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
    private String firstResult = "";

    public GooglePage() {
        super(driver);

    }
    
    public void navigateToGoogle(){

        navigateTo("https://www.google.com");

    }

    public void clickAcceptCookies(){

        clickElement(acceptCookies);

    }

    public void enterSearchCriteria(String criteria){

        write(searchFieldText,criteria);
    }



    
    public void clickGoogleSearch(){

        clickElement(searchButton);

    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
    
}
