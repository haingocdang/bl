@Check_VCX
Feature: Check Tỷ lệ VCX

########################################### Scenario 1 ###########################################
  Scenario: Data display correctly for VCX
    Given I launch and login Jupiter page as admin
    And I open "Bản chào" page
    When I click "Tạo mới" button
    And I select "Nhóm sản phẩm" dropdown list with "Nhóm sản phẩm" value
      | Nhóm sản phẩm |
      |  Xe |
    And I select "Tên sản phẩm" dropdown list with "Tên sản phẩm" value
      | Tên sản phẩm |
      | Ô tô         |

   # And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
   #  | Loại Bản Chào |
   # | Mới           |
   # When I click "Thông tin đối tượng tham gia" section
   # And I click "Phạm vi bảo hiểm" section
    #And I click + button
    #Then Đối tượng tham gia bảo hiểm Nhóm section appears
    And VCX display correct value <Tỷ Lệ> when selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and and "Mục Đích Sử Dụng" with value <Mục Đích Sử Dụng> and "Loại Xe" with value <Loại Xe> and "Nhóm Xe" with value <Nhóm Xe>
      | Hãng Xe | Hiệu Xe | Mục Đích Sử Dụng | Loại Xe | Nhóm Xe | Tỷ Lệ |