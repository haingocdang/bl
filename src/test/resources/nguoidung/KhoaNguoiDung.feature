@Khoa_Nguoi_Dung
Feature: Khoa/ Mo Khoa Nguoi Dung with scheduled time

  Scenario: Khoá and Mở Khóa Người Dùng with scheduled time from context menu
    Given I login Admin page as admin
    And I open "Người dùng" page
    When I select "Khoá" record "test005" from context menu
    Then "Khoá Người dùng" popup appears
    #And "Khoá Người dùng" popup has button "Khoá"
    And "Khoá Người dùng" popup has button "Hủy"
    And "Khoá Người dùng" popup has label "Khoá Người dùng"
    And "Khoá Người dùng" popup has text area "Lý do khóa"
    And "Khoá Người dùng" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Khoá" button is disabled
    And User unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Khoá Người dùng" popup is closed
    When I select "Khoá" record "test005" from context menu
    And I click Close button
    Then "Khoá Người dùng" popup is closed
    When I select "Khoá" record "test005" from context menu
    #And I input "Ngày hiệu lực" datetime picker with value "08-01-2021 09:21"
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do khóa" textarea with value "Test 0801"
    Then "Khoá" button is enabled
    When I click "Khoá" button
    Then toast message "Đã xác nhận khóa." appears
   # if current date time is before scheduled time "08-01-2021 09:21"
    And Trạng thái of "test005" displays "Đang hoạt động"
   # if current date time is equal scheduled time "08-01-2021 09:21"
    And I wait to inputted date time
    And Trạng thái of "test005" displays "Bị Khoá"
    Then Chỉnh Sửa Lần Cuối of "test005" displays correctly
    And Vô Hiệu Hóa Phòng Ban action is recored into Lịch Sử Chức Năng
    And "Phòng Ban" is disabled in "Tạo Người Dùng" page
    And "Phòng Ban" is disabled in detail "Người Dùng" page
    When I select "Mở khoá" record "test005" from context menu
    And I click "Mở khoá" button
    #Then toast message "Mở khóa thành công." appears
    And Trạng thái of "test005" displays "Đang hoạt động"
    And Khôi Phục Phòng Ban action is recored into Lịch Sử Chức Năng


