﻿Create database DATABASE_NHOM6_SHOPTAO
GO
USE DATABASE_NHOM6_SHOPTAO
GO


IF OBJECT_ID('ChucVu') IS NOT NULL
DROP TABLE ChucVu
CREATE TABLE ChucVu (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
CONSTRAINT PK_ChucVu PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('NhanVien') IS NOT NULL
DROP TABLE NhanVien
CREATE TABLE NhanVien (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
HoTen NVARCHAR(50) DEFAULT NULL,
GioiTinh NVARCHAR(50) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Sdt VARCHAR(10) DEFAULT NULL,
MatKhau NVARCHAR(50) DEFAULT NULL,
TrangThai INT DEFAULT NULL,
IDCH UNIQUEIDENTIFIER,
IDCV UNIQUEIDENTIFIER,
CONSTRAINT PK_NhanVien PRIMARY KEY(ID),
CONSTRAINT PK_NhanVien_ChucVu FOREIGN KEY (IDCV) REFERENCES ChucVu
)
GO
IF OBJECT_ID('KhuyenMai') IS NOT NULL
DROP TABLE KhuyenMai
CREATE TABLE KhuyenMai (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
NgayBatDau DATE DEFAULT NULL,
NgayKetThuc DATE DEFAULT NULL,
TrangThai Int,
CONSTRAINT PK_KhuyenMai PRIMARY KEY(ID)
)
GO
IF OBJECT_ID('SanPham') IS NOT NULL
DROP TABLE SanPham
CREATE TABLE SanPham (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
IDKhuyenMai UNIQUEIDENTIFIER,
CONSTRAINT PK_SanPham PRIMARY KEY(ID),
CONSTRAINT PK_SanPham_KhuyenMai FOREIGN KEY (IDKhuyenMai) REFERENCES KhuyenMai
)
GO
IF OBJECT_ID('NhaSanXuat') IS NOT NULL
DROP TABLE NhaSanXuat
CREATE TABLE NhaSanXuat(
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
CONSTRAINT PK_NhaSanXuat PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('DungLuong') IS NOT NULL
DROP TABLE DungLuong
CREATE TABLE DungLuong (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
CONSTRAINT PK_DungLuong PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('DongSanPham') IS NOT NULL
DROP TABLE DongSanPham
CREATE TABLE DongSanPham (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
CONSTRAINT PK_DongSanPham PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('MauSac') IS NOT NULL
DROP TABLE MauSac
CREATE TABLE MauSac (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
Ten NVARCHAR(50) DEFAULT NULL,
CONSTRAINT PK_MauSac PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('ChiTietSP') IS NOT NULL
DROP TABLE ChiTietSP
CREATE TABLE ChiTietSP (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
IDSanPham UNIQUEIDENTIFIER,
IDDongSanPham UNIQUEIDENTIFIER,
IDDungLuong UNIQUEIDENTIFIER,
IDMauSac UNIQUEIDENTIFIER,
IDNhaSanXuat UNIQUEIDENTIFIER,
SoLuongTon NVARCHAR(50) DEFAULT NULL,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
KichThuocManHinh FLOAT,
NamBaoHanh INT DEFAULT 0,
MoTa NVARCHAR(250),
TrangThai INT,
CONSTRAINT PK_ChiTietSP PRIMARY KEY(ID),
CONSTRAINT PK_ChiTietSP_SanPham FOREIGN KEY (IDSanPham) REFERENCES SanPham,
CONSTRAINT PK_ChiTietSP_DungLuong FOREIGN KEY (IDDungLuong) REFERENCES DungLuong,
CONSTRAINT PK_ChiTietSP_DongSanPham FOREIGN KEY (IDDongSanPham) REFERENCES DongSanPham,
CONSTRAINT PK_ChiTietSP_MauSac FOREIGN KEY (IDMauSac) REFERENCES MauSac,
CONSTRAINT PK_ChiTietSP_NhaSanXuat FOREIGN KEY (IDNhaSanXuat) REFERENCES NhaSanXuat
)
GO
IF OBJECT_ID('KhachHang') IS NOT NULL
DROP TABLE KhachHang
CREATE TABLE KhachHang (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
HoTen NVARCHAR(50) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Sdt VARCHAR(10) DEFAULT NULL,
DiaChi NVARCHAR(50) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
TrangThai INT,
CONSTRAINT PK_KhachHang PRIMARY KEY(ID),
)
GO
IF OBJECT_ID('HoaDon') IS NOT NULL
DROP TABLE HoaDon
CREATE TABLE HoaDon (
ID UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL,
Ma VARCHAR(50) UNIQUE DEFAULT NULL,
NgayTao DATE DEFAULT NULL,
IDKhachHang UNIQUEIDENTIFIER,
IDNhanVien UNIQUEIDENTIFIER,
CONSTRAINT PK_HoaDon PRIMARY KEY(ID),
CONSTRAINT PK_HoaDon_KhachHang FOREIGN KEY (IDKhachHang) REFERENCES KhachHang,
CONSTRAINT PK_HoaDon_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NhanVien,
)
GO
IF OBJECT_ID('HoaDonChiTiet') IS NOT NULL
DROP TABLE HoaDonChiTiet
CREATE TABLE HoaDonChiTiet (
IdHoaDon UNIQUEIDENTIFIER ,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia INT,
CONSTRAINT PK_HoaDonChiTiet PRIMARY KEY(IdHoaDon,IDChiTietSP),
CONSTRAINT PK_HoaDonChiTiet_HoaDon FOREIGN KEY (IDHoaDon) REFERENCES HoaDon,
CONSTRAINT PK_HoaDonChiTiet_ChiTietSP FOREIGN KEY (IDChiTietSP) REFERENCES ChiTietSP
)
GO

