@Check_TNDSTN
Feature: Check Tỷ lệ TNDSTN

########################################### Scenario 1 ###########################################
  Scenario: Data display correctly for TNDSTN
    Given I launch and login Jupiter page
    And I open "Bản chào" page
    When I click "Tạo Mới" button
    And I select "Nhóm sản phẩm" drop down list with "Nhóm sản phẩm" value
      | Nhóm sản phẩm |
      |  Xe |
    And I select "Tên sản phẩm" drop down list with "Tên sản phẩm" value
      | Tên sản phẩm |
      |  Ô tô |

    And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
      | Loại Bản Chào |
      |  Mới |
    And I click + button
    Then Đối tượng tham gia bảo hiểm Nhóm section appears
    And TNDSTN Về Người display correct value <Tỷ Lệ> when selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and "Mục đích sử dụng" with value <Mục Đích Sử Dụng> and "Loại xe" with value <Loại Xe> and "Nhóm xe" with value <Nhóm Xe> and inputting "Số chỗ" with value <Số Chỗ Ngồi> and inputting "Trọng tải" with value <Trọng Tải>
      | Hãng Xe | Hiệu Xe | Mục Đích Sử Dụng | Loại Xe | Nhóm Xe | Số Chỗ Ngồi | Trọng Tải | Tỷ Lệ |