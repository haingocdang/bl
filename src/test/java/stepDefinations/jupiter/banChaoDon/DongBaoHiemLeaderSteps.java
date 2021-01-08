package stepDefinations.jupiter.banChaoDon;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DongBaoHiemLeaderSteps {
    @Given("^I create a Đối Tượng Bảo Hiểm has following info \"([^\"]*)\" with value <Số tiền bảo hiểm / MTN> and \"([^\"]*)\" with value <Phí Bảo Hiểm Trước Thuế> and \"([^\"]*)\" with value <Thuế> and \"([^\"]*)\" with value <Phí Sau Thuế>$")
    public void iCreateADoiTuongBaoHiem(String MTN, String phiBaoHiemTruocThue, String Thue, String phiSauThue, DataTable data) {

    }

    @When("^I select Đồng Bảo Hiểm \"([^\"]*)\"$")
    public void iSelectDongBaoHiem(String arg1) {

    }

    @When("^I input \"([^\"]*)\" into \"([^\"]*)\" for Bảo Long$")
    public void iInputIntoForBaoLong(String inputValue, String inputField) {

    }

    @When("^I input \"([^\"]*)\" into \"([^\"]*)\" for Nhà Đồng \"([^\"]*)\"$")
    public void iInputIntoForNhaDong(String inputValue, String inputField, String nhaDong) {

    }

    @Then("^\"([^\"]*)\" for Nhà Đồng \"([^\"]*)\" display \"([^\"]*)\"$")
    public void forNhaDongDisplay(String arg1, String arg2, String arg3) {

    }

    @Then("^\"([^\"]*)\" with value <Phí QL đồng bh\\(chưa thuế\\)> and \"([^\"]*)\" with value <Thuế Quản Lý> and \"([^\"]*)\" with value <Phí QL đồng gồm thuế> and \"([^\"]*)\" with value <Số tiền bảo hiểm / MTN> and \"([^\"]*)\" with value <Phí Bảo Hiểm Trước Thuế> and \"([^\"]*)\" with value <Thuế> and \"([^\"]*)\" with value <Phí Sau Thuế> of Bảo Long display correctly$")
    public void checkValuesDongBaoHiemBaoLong(String phiQLDongChuaThue, String thueQuanLy, String phiQLDongGomThue, String MTN, String phiBHTruocThue, String thue, String phiSauThue, DataTable data){


    }

    @Then("^\"([^\"]*)\" with value <Phí QL đồng bh\\(chưa thuế\\) > and \"([^\"]*)\" with value <Thuế Quản Lý> and \"([^\"]*)\" with value <Phí QL đồng gồm thuế> and \"([^\"]*)\" with value <Số tiền bảo hiểm / MTN> and \"([^\"]*)\" with value <Phí Bảo Hiểm Trước Thuế> and \"([^\"]*)\" with value <Thuế> and \"([^\"]*)\" with value <Phí Sau Thuế> of Nhà Đồng \"([^\"]*)\"  display correctly$")
    public void CheckValueDongBaoHiemNhaDong(String phiQLDongChuaThue, String thueQuanLy, String phiQLDongGomThue, String MTN, String phiBHTruocThue, String thue, String phiSauThue, DataTable data)  {

    }

}
