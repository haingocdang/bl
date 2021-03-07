@Check_TNDSTN
Feature: Check Tỷ lệ TNDSTN

########################################### Scenario 1 ###########################################
  Scenario: Data display correctly for TNDSTN
    Given I launch and login Jupiter page as admin
    And I open "Bản chào" page
    When I click "Tạo mới" button
    And I select "Nghiệp vụ" dropdown list with "Nghiệp vụ" value
      | Nghiệp vụ |
      |  Xe |
    And I select "Tên sản phẩm" dropdown list with "Tên sản phẩm" value
      | Tên sản phẩm |
      | Ô tô         |
    And I click "Đối tượng bảo hiểm" tab
   # And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
   #  | Loại Bản Chào |
   # | Mới           |
   # When I click "Thông tin đối tượng tham gia" section
   # And I click "Phạm vi bảo hiểm" section
    And I click "Thêm thông tin đối tượng" icon
    #Then Đối tượng tham gia bảo hiểm Nhóm section appears
    And TNDSTN display correct value <Tỷ Lệ> when selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and and "Mục Đích Sử Dụng" with value <Mục Đích Sử Dụng> and "Loại Xe" with value <Loại Xe> and "Nhóm Xe" with value <Nhóm Xe>
      | Hãng Xe | Hiệu Xe | Mục Đích Sử Dụng | Loại Xe | Nhóm Xe | Tỷ Lệ |