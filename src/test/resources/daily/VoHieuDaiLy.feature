@Vo_Hieu_Dai_Ly
Feature: Vô Hiệu/ Khôi Phục Dai Ly with scheduled time

  Scenario: Vô Hiệu and Khôi Phục Đại Lý with scheduled time from context menu
    Given I login Admin page as admin
    And I open "Đại lý" page
    When I select "Vô hiệu" record "Bình Chánh" from context menu
    Then "Vô hiệu hóa Đại lý" popup appears
    And "Vô hiệu hóa Đại lý" popup has button "Vô hiệu"
    And "Vô hiệu hóa Đại lý" popup has button "Hủy"
    And "Vô hiệu hóa Đại lý" popup has label "Vô hiệu hóa Đại lý"
    And "Vô hiệu hóa Đại lý" popup has text area "Lý do vô hiệu hóa"
    #And "Vô hiệu hóa Đại lý" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Vô hiệu hóa" button is disabled
    And User unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Đại lý" popup is closed
    When I select "Vô hiệu" record "Bình Chánh" from context menu
    And I click Close button
    Then "Vô hiệu hóa Đại lý" popup is closed
    When I select "Vô hiệu" record "Bình Chánh" from context menu
    #And I input "Ngày hiệu lực" datetime picker with value "08-01-2021 09:21"
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
    Then "Vô Hiệu Hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hoá." appears
   # if current date time is before scheduled time "08-01-2021 09:21"
    And Trạng thái of "Bình Chánh" displays "Đang hoạt động"
   # if current date time is equal scheduled time "08-01-2021 09:21"
    And I wait to inputted date time
    And Trạng thái of "Bình Chánh" displays "Ngừng hoạt động"
    Then Chỉnh Sửa Lần Cuối of "Bình Chánh" displays correctly
    And Vô Hiệu Hóa Đại Lý action is recored into Lịch Sử Chức Năng
    When I select "Khôi phục" record "Bình Chánh" from context menu
    And I click "Khôi phục" button
    Then toast message "Khôi phục thành công." appears
    And Trạng thái of "Bình Chánh" displays "Đang hoạt động"
    And Khôi Phục Chức Năng action is recored into Lịch Sử Phòng Ban


