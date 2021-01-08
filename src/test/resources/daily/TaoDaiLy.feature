@Tao_Dai_Ly
Feature: Đại Lý Tổ Chức

  Scenario: Create "Đại Lý Tổ Chức" with all fields
    Given I login Admin page as admin
    When I open "Đại lý" page
    And I click "Tạo mới" button
    Then "Loại đại lý" drop down list show correct "Loại Đại Lý Option"
      | Loại Đại Lý Option |
      | Cá nhân            |
      | Tổ chức            |
    When I select "Loại đại lý" drop down list with "Loại Đại Lý Option" value
      | Loại Đại Lý Option |
      | Tổ chức            |
    Then "Đại lý cấp trên" drop down list display Đại Lý Tổ Chức value
    When I select "Kênh phân phối" drop down list with "Bancas" value
    And I select "Tên đối tác phân phối" drop down list with "" value
    And I input "Tên đại lý" with value "Đại lý Đa Kao"
    And I select "Đại lý cấp trên" drop down list with "" value
    And I input "Mã số thuế" textbox with value "987654321"
    And I input "Điện thoại" textbox with value "123456789"
    And I input "Email" textbox with value "hai.dang@alpaca.vn"
    And I input "Số hợp đồng đại lý" textbox with value "02468"
    And I input "Số GCN đại lý" textbox with value "13579"
    And I input "Ngày hiệu lực" datetime picker with value "31-12-2020"
    Then "Ngày hết hiệu lực" datetime picker display Ngày Hiệu Lực plus 1 year
    When I input "Ngày hết hiệu lực" datetime picker with value "31-01-2021"
    Then "Địa chỉ liên hệ" drop down list show correct "Địa chỉ liên hệ Option"
      | Địa chỉ liên hệ Option     |
      | Địa chỉ đăng ký kinh doanh |
      | Địa chỉ giao dịch          |
    And "Tỉnh/ Thành phố" drop down list show correct value <Tỉnh/ Thành phố>
      | Tỉnh/ Thành phố |
    And "Quận/ Huyện" drop down list show correct value <Quận/ Huyện> after selecting "Tỉnh/ Thành phố" with value <Tỉnh/ Thành phố>
      | Tỉnh/ Thành phố | Quận/ Huyện |
    And "Phường/ Xã" drop down list show correct value <Phường/ Xã> after selecting "Tỉnh/ Thành phố" with value <Tỉnh/ Thành phố> and selecting "Quận/ Huyện" with value <Quận/ Huyện>
      | Tỉnh/ Thành phố | Quận/ Huyện | Phường/ Xã |
    When I select "Tỉnh/ Thành phố" with value <Tỉnh/ Thành phố> and select "Quận/ Huyện" with value <Quận/ Huyện> and select "Phường/ Xã" with value <Phường/ Xã>
    And I input "Địa chỉ" textbox with value "185 Điện Biên Phủ"
    And I input "Số tài khoản" textbox with value "147258369"
    And I select "Ngân hàng" drop down list with "Ngân Hàng" value
      | Ngân Hàng |
      | ACB       |
    And I input "Thuế đại lý" textbox with value "20%"
    And I input "Thông tin người liên hệ" textbox with value "Đặng Ngọc Hải"
    And I click "Tạo" button
    Then toast message "Tạo thành công." appears
    And "Mã đại lý" displays correct value "DL.01.21.XXXX"
    And Trạng thái of "DL.01.21.XXXX" displays "Đang hoạt động"
    When I view "Tên Đại Lý" with value ""
    Then detail Đại Lý display correct value
    When I view "Mã Đại Lý" with value ""
    Then detail Đại Lý display correct value