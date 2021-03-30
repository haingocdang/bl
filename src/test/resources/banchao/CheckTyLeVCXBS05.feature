@Check_VCX05
Feature: Check Tỷ lệ VCX

########################################### Scenario 1 ###########################################
  Scenario: Data display correctly for VCX
    Given I launch and login Jupiter page as admin
    And I open "Bản chào" page
    When I click "Tạo mới" button
    And I select "Nghiệp vụ" dropdown list with "Nghiệp vụ" value
      | Nghiệp vụ|
      |  Xe cơ giới |
    And I select "Tên sản phẩm" dropdown list with "Tên sản phẩm" value
      | Tên sản phẩm |
      | Xe ô tô (DEMO_V1.1) |
  #  And I select "Loại sản phẩm" dropdown list with "Loại sản phẩm" value
  #    | Loại sản phẩm |
  #    | Sản phẩm đơn |

    And I click "Đối tượng bảo hiểm" tab
    And I click "Thêm thông tin đối tượng" icon

   # And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
   #  | Loại Bản Chào |
   # | Mới           |
   # When I click "Thông tin đối tượng tham gia" section
    #And I click "Phạm vi bảo hiểm" section
    #And I click + button
    #Then Đối tượng tham gia bảo hiểm Nhóm section appears
    And VCXBS05 display correct value <Tỷ Lệ> when selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and and "Mục Đích Sử Dụng" with value <Mục Đích Sử Dụng> and "Loại Xe" with value <Loại Xe> and "Nhóm Xe" with value <Nhóm Xe>
      | Hãng Xe | Hiệu Xe | Mục Đích Sử Dụng | Loại Xe | Nhóm Xe | Tỷ Lệ |