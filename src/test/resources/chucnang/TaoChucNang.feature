@Tao_Chuc_Nang
Feature: Tạo Chức Năng

  Scenario Outline: Create Chức Năng with all fields
    Given I login Admin page as admin
    And I open "Chức năng" page
   # When I click "Tạo mới" button
   # And I input "Tên chức năng" with value "<Tên Chức Năng>"
   # And I click "Tạo" button
   # Then toast message "Tạo thành công." appears
    And Trạng thái of "<Tên Chức Năng>" display "<Trạng Thái>"
    And Danh sach Chức Năng display current date time for <Chỉnh Sửa Lần Cuối>
    When I view detail page "Tên Chức Năng" with value <Tên Chức Năng>
   Then Chức Năng detail page display correct value <Tên Chức Năng>


    Examples:
      | Tên Chức Năng | Trạng Thái | Chỉnh Sửa Lần Cuối |
      | Chăm sóc khách hàng | Đang hoạt động | date time |
      | Giám định | Ngừng hoạt động | date time |

