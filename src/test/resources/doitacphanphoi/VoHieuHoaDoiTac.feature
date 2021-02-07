@Vo_Hieu_Chuc_Nang
Feature: Vô Hiệu/ Khôi Phục Đối tác with scheduled time


  Scenario: User able to Vô Hiệu/Khôi Phục Đối Tác (have no child) with scheduled date time from context menu
    Given I launch login Admin page as admin
    And I open "Đối tác" page
    When I select "Vô hiệu hóa" record "" from context menu
    Then "Vô hiệu hóa Đối tác phân phối" popup appears
    And "Vô hiệu hóa Đối tác phân phối" popup has label "Vô hiệu hóa Đối tác phân phối"
    And "Vô hiệu hóa Đối tác phân phối" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Vô hiệu hóa Đối tác phân phối" popup has text area "Lý do vô hiệu hóa"
    And "Vô hiệu hóa Đối tác phân phối" popup has button "Vô hiệu hóa"
    And "Vô hiệu hóa Đối tác phân phối" popup has button "Hủy"
    And "Vô hiệu hóa" button is disabled
    And user unabled to select the last date from date time picker "Ngày hiệu lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Đối tác phân phối" popup is closed
    When I select "Vô hiệu hóa" record "" from context menu
    And I click Close button
    Then "Vô hiệu hóa Đối tác phân phối" popup is closed
    When I select "Vô hiệu hóa" record "" from context menu
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
    Then "Vô hiệu hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hóa." appears
    And Trạng thái of "" displays "Đang hoạt động"
    And Trạng thái of "" displays "Ngừng hoạt động"
    Then Chỉnh Sửa Lần Cuối of "" displays correctly
    And Vô Hiệu Hóa Đối Tác action is recored into Lịch Sử Đối Tác
    And "Chức Năng" is disabled in "Tạo Người Dùng" page
    And "Chức Năng" is disabled in detail "Người Dùng" page
    When I select "Khôi phục" record "" from context menu
    And I click "Khôi phục" button
    Then toast message "Khôi phục thành công." appears
    And Trạng thái of " displays "Đang hoạt động"
    And Khôi Phục Đối Tác action is recored into Lịch Sử Đối Tác


  Scenario: User able to Vô Hiệu Đối Tác(have no child) with scheduled date time from detail page
    Given I login as admin
    And I open "Đối tác" page
    When  I view detail "Tên đối tác phân phối" with value ""
    And I click "Vô hiệu hóa" icon
    Then "Vô hiệu hóa Đối tác phân phối" popup appears
    And "Vô hiệu hóa Đối tác phân phối" popup has label "Vô hiệu hóa Đối tác phân phối"
    And "Vô hiệu hóa Đối tác phân phối" popup has date time picker "Ngày hiệu lực"
    And date time picker "Ngày hiệu lực" display current time
    And "Vô hiệu hóa Đối tác phân phối" popup has text area "Lý do vô hiệu hóa"
    And "Vô hiệu hóa Đối tác phân phối" popup has button "Vô hiệu hóa"
    And "Vô hiệu hóa Đối tác phân phối" popup has button "Hủy"
    And "Vô hiệu hóa" button is disabled
    And user unabled to select the last date from date time picker "Ngày Hiệu Lực"
    When I click "Hủy" button
    Then "Vô hiệu hóa Đối tác phân phối" popup is closed
    When  I view detail "Tên đối tác phân phối" with value ""
    And I click "Vô hiệu hóa" icon
    And I click "x" button
    Then "Vô hiệu hóa Đối tác phân phối" popup is closed
    When  I view detail "Tên đối tác phân phối" with value ""
    And I click "Vô hiệu hóa" icon
    And I input "Ngày hiệu lực" datetime picker with current date time plus "1" minutes
    And I input "Lý do vô hiệu hóa" textarea with value "Test 0801"
    Then "Vô hiệu hóa" button is enabled
    When I click "Vô hiệu hóa" button
    Then toast message "Đã xác nhận vô hiệu hóa." appears
    And Trạng thái of "" displays "Đang hoạt động"
    And I wait to inputted date time
    And Trạng thái of "" displays "Ngừng hoạt động"
    Then Chỉnh Sửa Lần Cuối of "" displays correctly
    And Vô Hiệu Hóa Chức Năng action is recored into Lịch Sử Đối Tác
    And "Chức Năng" is disabled in "Tạo Người Dùng" page
    And "Chức Năng" is disabled in detail "Người Dùng" page
    When I select "Khôi Phục" of a Đối Tác from detail page
    Then toast message "Khôi phục thành công." appears
    And Trạng thái of "" displays "Đang hoạt động"
    And Khôi Phục Đối Tác action is recored into Lịch Sử Đối Tác