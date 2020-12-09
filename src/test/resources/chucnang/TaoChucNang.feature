@Tao_Chuc_Nang
Feature: Tạo Chức Năng

  Scenario: Create Chức Năng with all fields
    Given I login Admin page as admin
    When I open "Chức năng" page
    Then toast message "Tạo thành công." appears and Trạng Thái is "Đang hoạt động" and info of Chuc Nang display correctly in Danh Sach Chuc Nang Page and Detail page after I click Tạo Mới button and I input <Tên Chức Năng> and I click Tạo button
      | Tên Chức Năng |
  #    Then toast message "Tạo thành công" appears
  #  And Trạng thái display "Đang hoạt động"
  #    | Tên Chức Năng   |
  #    | <Tên Chức Năng> |
  #  And Danh sách Chức Năng data display correct value
  #    | Tên Chức Năng   |
  #    | <Tên Chức Năng> |
  #  And Danh sach Chức Năng display current date time for "Chỉnh Sửa Lần Cuối"
  #    | Tên Chức Năng   |
  #    | <Tên Chức Năng> |
  #  When I view detail page
  #    | Tên Chức Năng   |
  #    | <Tên Chức Năng> |
  #  Then Chức Năng detail page display correct value
  #    | Tên Chức Năng   |
  #    | <Tên Chức Năng> |

#    Examples:
#      | Tên Chức Năng |
#      | Test |
#      | Tài chính kế hoạch  |
  ##@externaldata@./src/test/resources/data/TestData.xlsx@Sheet1
#      | Tài chính kế hoạch  |
#      | Kế toán             |
#      | Quản lý rủi ro      |
#      | Chăm sóc khách hàng |
