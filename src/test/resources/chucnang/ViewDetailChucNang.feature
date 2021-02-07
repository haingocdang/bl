@View_Detail_Chuc_Nang
Feature: Vô Hiệu/ Khôi Phục Chức Năng with scheduled time

  # Scenario: Vô Hiệu and Khôi Phục Chức Năng with scheduled time from context menu
#     Given I login Admin page as admin
#    And I open "Phòng ban" page
#    When I view detail "Tên phòng ban" with value "Chăm sóc khách hàng"
  Scenario: Lịch Sử Chỉnh Sửa "Đại Lý Cá Nhân" with all fields
    Given I launch login Admin page as admin
    And I create a Đại Lý Cá Nhân with value
      | Loại Đại Lý | Tên Đại Lý | Đại Lý Cấp Trên | Kênh Phân Phối | Tên Đối Tác Phân Phối |  Loại ID | Số ID | Ngày Sinh | Giới Tính | Số Điện Thoại | Email | Số Hợp Đồng Đại Lý | Số GCN Đại Lý | Ngày Hiệu Lực | Ngày Hệt Hiệu Lực | Tỉnh/ Thành phố | Quận/ Huyện | Phường/ Xã | Địa Chỉ | Mã Số Thuế Cá Nhân | Số Tài Khoản | Ngân Hàng | Thuế Đại Lý | Thông Tin Người Liên Hệ |
      | Cá Nhân | Hải Đặng | DL.02.21.0001 | Đại Lý | Đối tác 123 | CMND | 12345678 | 01-01-1990 | Nam | 230623305 | hai.dang@alpaca.vn | 123456789 | 987654654 | 01-12-2020 | 31-12-2021 | Hồ Chí Minh | Quận 1 | Phường Đa Kao | 185 Điện Biên Phủ | 258963111 | 111222333444 | HSBC | 20% | Alpaca |
    When I open "Đại lý" page
    And I view detail "Tên đại lý" with value "Hải Đặng"
    And I open Lịch Sử Chỉnh Sửa pane
    Then Lịch Sử Chỉnh Sửa display correctly value
      | User's Full Name | Action | Entity | Date time |
      | Hải Đạng | tạo | đại lý | date time |

    And Lịch Sử Chỉnh Sửa display correctly value when I select <Tên drop down list> with <Value>
      | User's Full Name | Action | Entity | Old value | New Value | Date time | Tên Drop down list | Value |
      | Hải Đặng | chuyển | Đại Lý Cấp Trên | từ DL.02.21.0001 | sang DL.02.21.0002. | date time | Đại lý cấp trên | DL.02.21.0002 |
      | Hải Đặng | chuyển | Kênh Phân Phối | từ Đại Lý | sang Bancas. | date time | Kênh phân phối | Bancas |
      | Hải Đặng | chuyển | Tên Đối Tác Phân Phối | từ Đối tác 123 | sang Đối tác 456. | date time | Tên đối tác phân phối | Đối tác 456 |
      | Hải Đặng | chuyển | Loại ID | từ CMND | sang CCCD. | date time | Loại ID | CCCD |
      | Hải Đặng | chuyển | Giới Tính | từ Nam | sang Nữ. | date time | Giới tính | Nữ |
      | Hải Đặng | chuyển | Tỉnh/Thánh Phố | từ Hồ Chí Minh | sang Gia Lai. | date time | Tỉnh/Thánh Phố | Gia Lai |
      | Hải Đặng | chuyển | Quận/ Huyện | từ Quận 1 | sang Pleiku. | date time | Quận/ Huyện | Pleiku |
      | Hải Đặng | chuyển | Phường/Xã | từ Phường Đa Kao | sang Phường Tây Sơn. | date time | Phường/Xã | Tây Sơn |
      | Hải Đặng | chuyển | Ngân Hàng | từ HSBC | sang ANZ. | date time | Ngân hàng | ANZ |


    And Lịch Sử Chỉnh Sửa display correctly value when I select <Tên datetime picker> datime picker with <Value>
      | User's Full Name | Action | Entity | Old value | New Value | Date time | Tên datetime picker | Value |
      | Hải Đặng | chuyển | Ngày Sinh | từ 01-01-1990 | sang 01-01-1998 | date time | Ngày sinh | 01-01-1998 |
      | Hải Đặng | chuyển | Ngày Hiệu Lực | từ 01-12-2020  | sang 01-01-2021  | date time | Ngày hiệu lực | 01-01-2021 |
      | Hải Đặng | chuyển | Ngày Hết Hiệu Lực | từ 31-12-2021  | sang 31-12-2022 | date time | Ngày hết hiệu lực | 31-12-2022 |


    And Lịch Sử Chỉnh Sửa display correctly value when I input <Tên Textbox> with <Value>
      | User's Full Name | Action | Entity | Old value | Date time | Tên Textbox | Value |
      | Hải Đặng | cập nhật | Tên Đại Lý | Hải Đặng |  date time | Tên đại lý | Hải Đặng Updated |
      | Hải Đặng | cập nhật | Số ID | 12345678 |  date time | Số ID| 888999777 |
      | Hải Đặng | cập nhật | Số Điện Thoại | 230623305 | date time | Số điện thoại | 11122233 |
      | Hải Đặng | cập nhật | Email | hai.dang@alpaca.vn | date time | Email | haidang@mailinator.com |
      | Hải Đặng | cập nhật | Số Hợp Đồng Đại Lý | 123456789 | date time | Số hợp đồng đại lý | 666555444 |
      | Hải Đặng | cập nhật | Số GCN Đại Lý | 987654654 | date time | Số GCN đại lý | 222555888 |
      | Hải Đặng | cập nhật | Địa Chỉ | 185 Điện Biên Phủ | date time | Địa chỉ | 1A Phan Xich Long |
      | Hải Đặng | cập nhật | Mã Số Thuế Cá Nhân | 258963111 | date time | Mã số thuế cá nhân | 999999999 |
      | Hải Đặng | cập nhật | Số Tài Khoản | 111222333444 | date time | Mã số thuế cá nhân | 888888888 |
      | Hải Đặng | cập nhật | Thuế Đại Lý | 20% | date time | Thuế đại lý | 50% |
      | Hải Đặng | cập nhật | Thông Tin Người Liên Hệ | Alpaca | date time | Thông tin người liên hệ | Đặng Ngọc Hải |

   


