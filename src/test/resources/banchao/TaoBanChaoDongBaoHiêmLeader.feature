@DongBaoHiemLeader
Feature: Tạo mới bản chào - Đông Bảo Hiểm

  Scenario: Nhà Đồng Leader-Data display correctly
    Given I launch and login Jupiter page
    And I create a Đối Tượng Bảo Hiểm has following info "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế>
      | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế      | Phí Sau Thuế |
      | 1,000,000,000          | 27,272,728              | 2,727,273 | 30,000,000   |
    When I select Đồng Bảo Hiểm "Leader"
    And I input "60%" into "Tỷ Lệ Đồng" for Bảo Long
    And I input "15%" into "Tỷ Lệ Đồng" for Nhà Đồng "1"
    And I input "25%" into "Tỷ Lệ Đồng" for Nhà Đồng "2"
    And I input "1%" into "Tỷ Lệ Phí Quản Lý Nhà Đồng" for Bảo Long
    Then "Tỷ Lệ Phí Nhà Đồng" for Nhà Đồng "1" display "1%"
    And "Tỷ Lệ Phí Nhà Đồng" for Nhà Đồng "2" display "1%"
    And "Phí QL đồng bh(chưa thuế)" with value <Phí QL đồng bh(chưa thuế)> and "Thuế Quản Lý" with value <Thuế Quản Lý> and "Phí QL đồng gồm thuế" with value <Phí QL đồng gồm thuế> and "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế> of Bảo Long display correctly
      | Phí QL đồng bh(chưa thuế)              | Thuế Quản Lý              | Phí QL đồng gồm thuế              | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế           | Phí Sau Thuế     |
      | Sum Phí QL đồng bh(chưa thuế) Nhà Đồng | Sum Thuế Quản Lý Nhà Đồng | Sum Phí QL đồng gồm thuế Nhà Đồng | 1,000,000,000 *60%     | 27,272,728 * 60%        | 2,727,273 *60% | 30,000,000 * 60% |
    And "Phí QL đồng bh(chưa thuế)" with value <Phí QL đồng bh(chưa thuế) > and "Thuế Quản Lý" with value <Thuế Quản Lý> and "Phí QL đồng gồm thuế" with value <Phí QL đồng gồm thuế> and "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế> of Nhà Đồng "1"  display correctly
      | Phí QL đồng bh(chưa thuế) | Thuế Quản Lý | Phí QL đồng gồm thuế | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế           | Phí Sau Thuế     |
      | Phí BH trước thuế * 1%    | Thuế *1%     | Phí Sau Thuế* 1%     | 1,000,000,000 *15%     | 27,272,728 * 15%        | 2,727,273 *15% | 30,000,000 * 15% |
    And "Phí QL đồng bh(chưa thuế)" with value <Phí QL đồng bh(chưa thuế) > and "Thuế Quản Lý" with value <Thuế Quản Lý> and "Phí QL đồng gồm thuế" with value <Phí QL đồng gồm thuế> and "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế> of Nhà Đồng "2"  display correctly
      | Phí QL đồng bh(chưa thuế) | Thuế Quản Lý | Phí QL đồng gồm thuế | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế           | Phí Sau Thuế     |
      | Phí BH trước thuế * 1%    | Thuế *1%     | Phí Sau Thuế* 1%     | 1,000,000,000 *25%     | 27,272,728 * 25%        | 2,727,273 *25% | 30,000,000 * 25% |

########################################### Scenario 2 ###########################################

  Scenario: Nhà Đồng Follow-Data display correctly in Nhà Đồng Follow
    Given I launch and login Jupiter page
    And I create a Đối Tượng Bảo Hiểm has following info "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế>
      | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế      | Phí Sau Thuế |
      | 1,000,000,000          | 27,272,728              | 2,727,273 | 30,000,000   |
    When I select Đồng Bảo Hiểm "Follow"
    And I input "60%" into "Tỷ Lệ Đồng" for Bảo Long

    And I input "1%" into "Tỷ Lệ Phí Quản Lý Nhà Đồng" for Bảo Long

    And "Phí QL đồng bh(chưa thuế)" with value <Phí QL đồng bh(chưa thuế)> and "Thuế Quản Lý" with value <Thuế Quản Lý> and "Phí QL đồng gồm thuế" with value <Phí QL đồng gồm thuế> and "Số Tiền Bảo Hiểm / MTN" with value <Số tiền bảo hiểm / MTN> and "Phí Bảo Hiểm Trước Thuế" with value <Phí Bảo Hiểm Trước Thuế> and "Thuế" with value <Thuế> and "Phí Sau Thuế" with value <Phí Sau Thuế> of Bảo Long display correctly
      | Phí QL đồng bh(chưa thuế)              | Thuế Quản Lý              | Phí QL đồng gồm thuế              | Số Tiền Bảo Hiểm / MTN | Phí Bảo Hiểm Trước Thuế | Thuế           | Phí Sau Thuế     |
      | Sum Phí QL đồng bh(chưa thuế) Nhà Đồng | Sum Thuế Quản Lý Nhà Đồng | Sum Phí QL đồng gồm thuế Nhà Đồng | 1,000,000,000 *60%     | 27,272,728 * 60%        | 2,727,273 *60% | 30,000,000 * 60% |
