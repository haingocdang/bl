@TaoBanChaoDon
Feature: Tạo mới bản chào đơn - thông tin chung

########################################### Scenario 1 ###########################################
	Scenario: Data display correctly in Thong Tin Chung section
		Given I upload file on Product Builder page
		And I launch and login Jupiter page
		And I open "Tạo bản chào" page
		When I select Nhom san pham drop down list with <Nhóm sản phẩm> value
			| Nhóm sản phẩm |
			|  Xe |
		And I select Ten San Pham drop down list with <Tên sản phẩm> value
			| Tên sản phẩm |
			|  Ô tô đơn |

		And I select Loai Ban Chao drop down list with <Loại Bản Chào> value
			| Loại Bản Chào |
			|  Mới |

		Then Bản Chào Đơn-Đối tượng tham gia bảo hiểm section appears
		And Hãng Xe display correct value <Hãng Xe> from PB
			| Hãng Xe |

########################################################

		And Hiệu Xe display correct value <Hiệu Xe> from PB and Dòng Xe display correct value <Dòng Xe> from PB after I select Hãng Xe with value <Hãng Xe>
			| Hãng Xe | Hiệu Xe | Dòng Xe |


########################################################

		And Nhóm Xe display correct value <Nhóm Xe> from PB and Mục Đích Sử Dụng display correct value <Mục Đích Sử Dụng> and Loại Xe display correct value <Loại Xe> from PB after selecting Hãng Xe with value <Hãng Xe> and Hiệu Xe with value <Hiệu Xe>
			| Hãng Xe | Hiệu Xe | Nhóm Xe | Mục Đích Sử Dụng |Loại Xe |

########################################################

		When I select Nhóm Xe with value <Nhóm Xe>
		And I select Mục Đích Sử Dụng with value <Mục Đích Sử Dụng>
		Then Loại Xe correct value <Loại Xe>
			| Hãng Xe | Hiệu Xe | Nhóm Xe | Mục Đích Sử Dụng | Loại Xe |
			| Hãng Xe | Hiệu Xe | Nhóm Xe | Mục Đích Sử Dụng | Loại Xe |

########################################################

		Then Giá Trị Xe display correct value <Giá Trị Xe> after selecting Hãng Xe with value <Hãng Xe> and Hiệu Xe with value <Hiệu Xe> and  Nơi San Xuất with value <Nơi Sản Xuất> and Năm Sản Xuất with value <Năm Sản Xuất>
			| Hãng Xe | Hiệu Xe | Nơi Sản Xuất | Năm Sản Xuất | Giá Trị Xe |
