@Tao_Nguoi_Dung
Feature: Tao Nguoi Dung
  As a Admin User I want to Tao Nguoi Dung

  Scenario: Tao Nguoi Dung with all valid fields
    Given I open Login page
    And I input "TEST" into username textbox
    And I input "12341234" into password textbox
    And I click Login button
    When I click to Tao Moi button
    And I input Ten Dang Nhap with value "haidang12601"
    And I input Ho Va Ten with value "Dang Ngoc Hai"
    And I input Email with value "haidang12601@mailinator.com"
    And I select "Đơn Vị" with value "BL Trụ Sở Chính"
    And I select "Phòng ban" with value "Xe cơ giới"
    And I select "Chức năng" with value "Quản lý chung"
    And I select "Vai trò" with value "Cấp 3"
    
