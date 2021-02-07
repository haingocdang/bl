Feature: Copy Ban Chao
  Là một Khai thác viên, tôi mong muốn copy bản chào để tạo ra 1 bản chào mới có thông tin giống thông tin bản chào ban đầu

  Acceptance Criteria

  Tôi mong muốn copy bản chào

  Các thông tin cần khai báo: Cho phép chỉnh sửa lại toàn bộ thông tin trên bản chào mới được copy

  Tạo mới thành công:

  Tạo ra một bản chào mới có mã bản chào là duy nhất

########################################### Scenario 1 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Đang Soạn Thảo" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Đang Soạn Thảo"
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

########################################### Scenario 2 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Trình Duyệt" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Trình Duyệt"
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"


########################################### Scenario 3 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Yêu Cầu Bổ Sung" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Yêu Cầu Bổ Sung"
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

########################################### Scenario 4 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Từ Chối" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Từ Chối"
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"


########################################### Scenario 5 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Đã Duyệt" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Đã Duyệt"
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I select "Sao chép bản chào" record "B0221000010" from context menu
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

 ########################################### Scenario 6 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Đang Soạn Thảo" from detail page
    Given I launch and login Jupiter page
    And I create a Bản Chào "Đang Soạn Thảo"
    When I view detail "Mã bản chào" with value ""B0221000010"
    And I click "Sao chép bản chào" icon
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

########################################### Scenario 7 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Trình Duyệt" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Trình Duyệt"
    When I view detail "Mã bản chào" with value "B0221000010"
    And I click "Sao chép bản chào" icon
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"


########################################### Scenario 8 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Yêu Cầu Bổ Sung" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Yêu Cầu Bổ Sung"
    When I view detail "Mã bản chào" with value "B0221000010"
    And I click "Sao chép bản chào" icon
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

########################################### Scenario 9 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Từ Chối" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Từ Chối"
    When I view detail "Mã bản chào" with value "B0221000010"
    And I click "Sao chép bản chào" icon
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"


########################################### Scenario 10 ###########################################
  Scenario: User able to "Copy Bản Chào" with Bản Chào "Đã Duyệt" from context menu
    Given I launch and login Jupiter page
    And I create a Bản Chào "Đã Duyệt"
    When I view detail "Mã bản chào" with value "B0221000010"
    And I click "Sao chép bản chào" icon
    Then "Sao chép bản chào" popup appears
    And "Sao chép bản chào" popup has label "Sao chép bản chào"
    And "Sao chép bản chào" popup has button "Hủy"
    And "Sao chép bản chào" popup has button "Chấp nhận"
    When I click "Hủy" button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click Close button
    Then "Sao chép bản chào" popup is closed
    When I click "Sao chép bản chào" icon
    And I click "Chấp nhận" button
    Then toast message "Sao chép bản chào thành công!" appears
    And there is copied "Bản chào" displays on list with status "Đang soạn thảo"
    And copied Bản Chào has uniquied Mã Bản Chào "B0221000011"
    And info of copied "Bản chào" displays same as original Bản Chào
    And I able to "Chỉnh sửa" all info of copied "Bản Chào"

########################################### Scenario 10 ###########################################
  Scenario: Only user that is creator or owner or upper level user be able to "Copy Bản Chào"
    Given I launch and login Jupiter page as user 001 and has level 2
    And I create a Bản Chào "B0221000010"
    When I launch and login Jupiter page as user 002 and has level 1
    And I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" option is disabled
    When I view detail "Mã bản chào" with value "B0221000010"
    Then "Sao chép bản chào" icon is disabled
    When I launch and login Jupiter page as user 003 and has level 2
    And I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" option is disabled
    When I view detail "Mã bản chào" with value "B0221000010"
    Then "Sao chép bản chào" icon is disabled
    When I launch and login Jupiter page as user 001 and has level 2
    And I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" option is enabled
    When I view detail "Mã bản chào" with value
    Then "Sao chép bản chào" icon is enabled
    When I launch and login Jupiter page as user 004 and has level 3
    And I select "Sao chép bản chào" record "B0221000010" from context menu
    Then "Sao chép bản chào" option is enabled
    When I view detail "Mã bản chào" with value "B0221000010"
    Then "Sao chép bản chào" icon is enabled
