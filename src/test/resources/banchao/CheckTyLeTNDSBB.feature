@Check_TNDSBB
Feature: Check Tỷ lệ DSTNBB

########################################### Scenario 1 ###########################################
  Scenario: Data display correctly for DSTNBB
    Given I launch and login Jupiter page as admin
    And I open "Bản chào" page
    When I click "Tạo mới" button
    And I select "Nghiệp vụ" dropdown list with "Nghiệp vụ" value
      | Nghiệp vụ |
      |  Xe |
    And I select "Tên sản phẩm" dropdown list with "Tên sản phẩm" value
      | Tên sản phẩm |
      |  Ô tô |
    And I click "Đối tượng bảo hiểm" tab
    And I click "Thêm thông tin đối tượng" icon

   # And I click "Thông tin xe" section
   # And I click "Phạm vi bảo hiểm" section
    #And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
     # | Loại Bản Chào |
      #|  Mới |
    And TNDSBB display correct value <Phí> when selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and "Mục Đích Sử Dụng" with value <Mục Đích Sử Dụng> and "Loại Xe" with value <Loại Xe> and "Nhóm Xe" with value <Nhóm Xe>
      | Hãng Xe | Hiệu Xe | Mục Đích Sử Dụng | Loại Xe | Nhóm Xe | Phí |
