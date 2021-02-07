@Vo_Hieu_Phong_Ban
Feature: Vô Hiệu/ Khôi Phục Chức Năng with scheduled time

  Scenario: Vô Hiệu and Khôi Phục Phòng Ban with scheduled time from context menu
    Given I login Admin page as admin
    And I open "Phòng ban" page
    When I select "Vô hiệu hoá" record "Chăm sóc khách hàng" from context menu
    Then "Vô hiệu hóa Phòng ban" popup appears
    And "Vô hiệu hóa Phòng ban" popup has button "Vô hiệu"
    And "Vô hiệu hóa Phòng ban" popup has button "Hủy"
    And "Vô hiệu hóa Phòng ban" popup has label "Vô hiệu hóa Phòng ban"
    And "Vô hiệu hóa Phòng ban" popup has text area "Lý do vô hiệu hóa"
    And "Vô hiệu hóa Phòng ban" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Vô hiệu hóa" button is disabled
    # And user unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Phòng Ban" popup is closed
    When I select "Vô hiệu" record "Chăm sóc khách hàng" from context menu
    And I click Close button
    Then "Vô hiệu hóa Phòng Ban" popup is closed
    When I select "Vô hiệu" record "Chăm sóc khách hàng" from context menu
    #And I input "Ngày hiệu lực" datetime picker with value "08-01-2021 09:21"
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
   # Then "Vô hiệu hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hoá." appears
   # if current date time is before scheduled time "08-01-2021 09:21"
    And Trạng thái of "Chăm sóc khách hàng" displays "Đang hoạt động"
   # if current date time is equal scheduled time "08-01-2021 09:21"
    And I wait to inputted date time
    And Trạng thái of "Chăm sóc khách hàng" displays "Ngừng hoạt động"
    Then Chỉnh Sửa Lần Cuối of "Chăm sóc khách hàng" displays correctly
   # And Vô Hiệu Hóa Phòng Ban action is recored into Lịch Sử Chức Năng
    And "Phòng Ban" is disabled in "Tạo Người Dùng" page
    And "Phòng Ban" is disabled in detail "Người Dùng" page
    When I select "Khôi phục" record "Chăm sóc khách hàng" from context menu
    And I click "Khôi phục" button
    Then toast message "Khôi phục thành công." appears
    And Trạng thái of "Chăm sóc khách hàng" displays "Đang hoạt động"
   # And Khôi Phục Phòng Ban action is recored into Lịch Sử Chức Năng


