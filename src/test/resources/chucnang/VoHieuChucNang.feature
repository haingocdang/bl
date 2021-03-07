@Vo_Hieu_Chuc_Nang
Feature: Vô Hiệu/ Khôi Phục Chức Năng with scheduled time
  Là một Quản trị viên (Admin), tôi muốn quản lý cấu trúc tổ chức để phục vụ các nghiệp vụ liên quan trong hệ thống.
  Acceptance Criteria
  Khi vô hiệu hóa một chức năng bất kỳ, cần nhập Lý Do Vô Hiệu Hóa. Khi xác nhận:
  Function status chuyển từ “Đang hoạt động” sang “Ngừng hoạt động”.
  Toast message: “Đã vô hiệu hóa.“
  Chức năng đang bị vô hiệu hóa sẽ không xuất hiện trong các chức năng liên quan.
  Khi khôi phục một chức năng đang bị vô hiệu hóa:
  Function status chuyển từ “Ngừng hoạt động” sang “Đang hoạt động”.
  Toast message: “Khôi phục thành công.“
  Notes
  Lý Do Vô Hiệu Hóa được ghi vào ‘Lịch Sử’ (History) của ‘Thông tin chức năng’.

  Scenario: Vô Hiệu and Khôi Phục Chức Năng with scheduled time from context menu
    Given I launch login Admin page as admin
    #Open <Ten Page> page
    And I open "Chức năng" page
    When I select "Vô hiệu hóa" record "Giám định bồi thường" from context menu
    Then "Vô hiệu hóa Chức năng" popup appears
    And "Vô hiệu hóa Chức năng" popup has button "Vô hiệu hóa"
    And "Vô hiệu hóa Chức năng" popup has button "Hủy"
    And "Vô hiệu hóa Chức năng" popup has label "Vô hiệu hóa Chức năng"
    And "Vô hiệu hóa Chức năng" popup has text area "Lý do vô hiệu hóa"
    And "Vô hiệu hóa Chức năng" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Vô hiệu hóa" button is disabled
    And User unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Chức năng" popup is closed
    When I select "Vô hiệu hóa" record "Giám định bồi thường" from context menu
    And I click Close button
    Then "Vô hiệu hóa Chức năng" popup is closed
    When I select "Vô hiệu hóa" record "Giám định bồi thường" from context menu
    #And I input "Ngày hiệu lực" datetime picker with value "08-01-2021 09:21"
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
    Then "Vô hiệu hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hóa." appears
   # if current date time is before scheduled time "08-01-2021 09:21"
    And Trạng thái of "Giám định bồi thường" displays "Đang hoạt động"
   # if current date time is equal scheduled time "08-01-2021 09:21"
    And I wait to inputted date time
    And Trạng thái of "Giám định bồi thường" displays "Ngừng hoạt động"

    #Verify Point
    Then Chỉnh Sửa Lần Cuối of "Giám định bồi thường" displays correctly
    And Vô Hiệu Hóa Chức Năng action is recored into Lịch Sử Chức Năng
    And "Chức Năng" is disabled in "Tạo Người Dùng" page
    And "Chức Năng" is disabled in detail "Người Dùng" page
    When I select "Khôi phục" record "Giám định bồi thường" from context menu
    And I click "Khôi phục" button
    Then toast message "Khôi phục thành công." appears
    And Trạng thái of "Giám định bồi thường" displays "Đang hoạt động"
    And Khôi Phục Chức Năng action is recored into Lịch Sử Chức Năng



