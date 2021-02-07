@TaoBanChaoDon
Feature: Tạo mới bản chào đơn - thông tin chung

########################################### Scenario 1 ###########################################
	Scenario: Data display correctly in Thong Tin Chung section of Xe Ô Tô
		Given I launch and login Jupiter page as admin
		And I open "Bản chào" page
		When I click "Tạo mới" button
		And I select "Nhóm sản phẩm" drop down list with "Nhóm sản phẩm" value
			| Nhóm sản phẩm |
			|  Xe |
		And I select "Tên sản phẩm" drop down list with "Tên sản phẩm" value
			| Tên sản phẩm |
			|  Ô tô |

	#	And I select "Loại bản chào" drop down list with "Loại Bản Chào" value
	#		| Loại Bản Chào |
	#		|  Mới |
		And I click "Thông tin đối tượng tham gia" section
		Then Bản Chào Đơn-Đối tượng tham gia bảo hiểm section appears
		And "Hãng xe" dropdown displays correct values
			| Hãng Xe |

########################################################

		And "Hiệu xe" display correct value <Hiệu Xe> from PB after selecting "Hãng xe" with value <Hãng Xe>
		| Hãng Xe |

########################################################

	#	And "Nhóm Xe" display correct value <Nhóm Xe> from PB and "Mục Đích Sử Dụng" display correct value <Mục Đích Sử Dụng> and "Dòng xe" display correct value <Dòng Xe> and "Số chỗ ngồi" dipsplay correct value <Số Chỗ Ngồi> and "Trọng tải" display correct value <Trọng Tải> after selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe>
	#		| Hãng Xe | Hiệu Xe | Nhóm Xe | Mục Đích Sử Dụng | Dòng Xe | Số Chỗ Ngồi | Trọng Tải |

########################################################

	#	And "Loại Xe" display correct value <Loại Xe> and "Nhóm Xe" display correct value <Nhóm Xe> after seleting <Hãng Xe> from "Hãng xe" and <Hiệu Xe> from "Hiệu xe" and <Mục Đích Sử Dụng> from "Mục Đích Sử Dụng"
	#		| Hãng Xe | Hiệu Xe | Nhóm Xe | Mục Đích Sử Dụng | Loại Xe |


########################################################

		Then "Giá trị xe đề xuất" display correct value <Giá Trị Xe Đề Xuất> after selecting "Hãng xe" with value <Hãng Xe> and "Hiệu xe" with value <Hiệu Xe> and "Năm sản xuất" with value <Năm Sản Xuất>
			| Hãng Xe | Hiệu Xe | Năm Sản Xuất | Giá Trị Xe Đề Xuất |

