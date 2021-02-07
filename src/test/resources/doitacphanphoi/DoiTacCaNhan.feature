@Tao_Doi_Tac
Feature: Đối Tác Cá Nhân

  Scenario Outline: Create "Đối Tác Phân Phối Cá Nhân" with required fields
    Given I login Admin page as admin
    When I open "Đối Tác Phân Phối" page
    And I click "Tọo mới" button
    When I select "Loại đối tác phân phối" drop down list with "<Loại Đối Tác Phân Phối>" value
    And I select "Kênh phân phối" drop down list with "<Kênh Phân Phối>" value
    And I input "Tên đối tác" textbox with value "<Tên Đối Tác>"
    And I select "Loại ID" drop down list with "<Loại ID>" value
    And I input "Số ID" textbox with value "<Số ID >"
    And I select "Giới tính" drop down list with "<Giới Tính>" value
    And I input "Số điện thoại" textbox with value "<Số Điện Thoại>"
    And I input "Ngày hiệu lực" datetime picker with value "<Ngày Hiệu Lực>"
    Then "Ngày hết hiệu lực" datetime picker display <Ngày Hết Hiệu Lực>
    When I select "Tỉnh/ Thành phố" with value <Tỉnh/ Thành phố> and select "Quận/ Huyện" with value <Quận/ Huyện> and select "Phường/ Xã" with value <Phường/ Xã>
    And I input "Địa chỉ" with value "<Địa Chỉ>"
    And I click "Tạo" button
    Then toast message "Tạo thành công." appears
    And "Mã đối tác phân phối" of "<Mã Đối Tác Phân Phối>" displays "<Mã Đối Tác Phân Phối>"
    And Trạng thái of "Mã Đối Tác Phân Phối" displays "<Trạng Thái>"
    And "Tên đối tác phân phối" of "<Mã Đối Tác Phân Phối>" displays "<Tên Đối Tác Phân Phối>"
    When I view "Tên đối tác" with value "<Tên Đối Tác>"
    Then detail Đối Tác display correct value
    When I view "Mã đối tác phân phối" with value "<Mã Đối Tác Phân Phối>"
    Then detail Đối Tác display correct value

    Examples:
      | Loại Đối Tác Phân Phối | Kênh Phân Phối | Tên Đối Tác | Đối Tác Cấp Trên | Loại ID | Số ID     | Ngày Sinh | Giới Tính | Số Điện Thoại | Email | Ngày Hiệu Lực | Ngày Hết Hiệu Lực | Tỉnh/Thành phố        | Quận/Huyện       | Phường/Xã      | Địa Chỉ           | Mã Số Thuế Cá Nhân | Số Tài Khoản | Thông Tin Người Liên Hệ | Mã Đối Tác Phân Phối | Trạng Thái     |
      | Cá nhân                | Bancassurance  | Đối Tác 001 |                  | CMND    | 123456789 |           | Nam       | 0911111111    |       | 31-12-2021    | 31-12-2022        | Thành phố Hồ Chí Minh | Quận 1           | Phường Đa Kao  | 185 Điện Biên Phủ |                    |              |                         | BA.004               | Đang hoạt động |
      | Cá nhân                | Hợp tác xã     | Đối Tác 002 |                  | CCCD    | 111222333 |           | Nữ        | 0922222222    |       | 31-12-2021    | 31-03-2021        | Tỉnh Gia Lai          | Thành Phố Pleiku | Phường Tây Sơn | 89 Lê Lợi         |                    |              |                         | HT.003               | Đang hoạt động |