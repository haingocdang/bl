@Vo_Hieu_Chuc_Nang
Feature: Vô Hiệu/ Khôi Phục Chức Năng with scheduled time

  Scenario: Vô Hiệu and Khôi Phục Chức Năng with scheduled time from context menu
    Given I login Admin page as admin
    And I open "Chức năng" page
    When I select "Vô hiệu" record "Giám định bồi thường" from context menu
    Then "Vô hiệu hóa Chức năng" popup appears
    And "Vô Hiệu Chức Năng" popup has button "Vô hiệu"
    And "Vô Hiệu Chức Năng" popup has button "Hủy"
    And "Vô Hiệu Chức Năng" popup has label "VÔ HiỆU HÓA ChỨC NĂNg"
    And "Vô Hiệu Chức Năng" popup has text area "Lý do vô hiệu hóa"
    And "Vô Hiệu Chức Năng" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And button "Vô hiệu hóa" is disabled if textarea "Lý do vô hiệu hóa" is blank
    And User unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Chức năng" popup is closed
    When I select "Vô hiệu" record "Giám định bồi thường" from context menu
    And I click Close button
    Then "Vô Hiệu Chức Năng" popup is closed
    When I select "Vô hiệu" record "Giám định bồi thường" from context menu
    #And I input "Ngày hiệu lực" datetime picker with value "08-01-2021 09:21"
    And I input "Ngày hiệu lực" datetime picker with current date time plus "2" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
    Then "Vô Hiệu Hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hoá." appears
   # if current date time is before scheduled time "08-01-2021 09:21"
    And Trạng thái of "Chăm sóc khách hàng" displays "Đang Hoạt Động"
   # if current date time is equal scheduled time "08-01-2021 09:21"
    And I wait to "08-01-2021 09:21"
    And Trạng thái of "Chăm sóc khách hàng" displays "Ngừng Hoạt Động"
    Then Chỉnh Sửa Lần Cuối of "Chăm sóc khách hàng" displays correctly
    And Vô Hiệu Hóa Chức Năng action is recored into Lịch Sử Chức Năng
    And "Chức Năng" is disabled in "Tạo Người Dùng" page
    And "Chức Năng" is disabled in detail "Người Dùng" page
    When I select "Khôi phục" record "Chăm sóc khách hàng" from context menu
    Then toast message "Khôi phục thành công." appears
    And Khôi Phục Chức Năng action is recored into Lịch Sử Chức Năng


