-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Jun 2018 pada 08.17
-- Versi Server: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sppk`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `debitcurahhujan`
--

CREATE TABLE `debitcurahhujan` (
  `id` int(11) NOT NULL,
  `curahhujan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `debitcurahhujan`
--

INSERT INTO `debitcurahhujan` (`id`, `curahhujan`) VALUES
(1, 'hujan ringan'),
(2, 'hujan sedang'),
(3, 'hujan lebat'),
(4, 'hujan sangat lebat');

-- --------------------------------------------------------

--
-- Struktur dari tabel `desa`
--

CREATE TABLE `desa` (
  `idDesa` int(11) NOT NULL,
  `kecamatan` int(11) NOT NULL,
  `desa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `desa`
--

INSERT INTO `desa` (`idDesa`, `kecamatan`, `desa`) VALUES
(1, 1, 'sd'),
(2, 1, 'tst'),
(3, 2, 'st'),
(4, 2, 'tst'),
(5, 2, 'sdts');

-- --------------------------------------------------------

--
-- Struktur dari tabel `fuzzifikasi`
--

CREATE TABLE `fuzzifikasi` (
  `id` int(11) NOT NULL,
  `idLK` int(11) DEFAULT NULL,
  `ftinggirendah` double DEFAULT NULL,
  `ftinggisedang` double DEFAULT NULL,
  `ftinggitinggi` double DEFAULT NULL,
  `fsuhupanas` double DEFAULT NULL,
  `fsuhusedang` double DEFAULT NULL,
  `fhujanringan` double DEFAULT NULL,
  `fhujansedang` double DEFAULT NULL,
  `fhujanlebat` double DEFAULT NULL,
  `fhujansangatlebat` double DEFAULT NULL,
  `fluassempit` double DEFAULT NULL,
  `fluasnormal` double DEFAULT NULL,
  `fluasluas` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `fuzzifikasi`
--

INSERT INTO `fuzzifikasi` (`id`, `idLK`, `ftinggirendah`, `ftinggisedang`, `ftinggitinggi`, `fsuhupanas`, `fsuhusedang`, `fhujanringan`, `fhujansedang`, `fhujanlebat`, `fhujansangatlebat`, `fluassempit`, `fluasnormal`, `fluasluas`) VALUES
(8, 2, -0.6521739130434783, 0.34782608695652173, 0, 1, 0, 0, -0.8333333333333334, 0.16666666666666666, 0, 1, 0, 0),
(9, 2, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 1, 0, 0),
(10, 2, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 1, 0.1007792754844145, 0),
(11, 3, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 1, 0, 0),
(12, 3, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.20608677337826453, 0),
(13, 3, 0, 0, 1, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.20608677337826453, 0),
(14, 3, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.20608677337826453, 0),
(15, 3, 0, 0.9565217391304348, 0, 0, 1, 0, 0, 0.6666666666666666, 0, 0, 0.20608677337826453, 0),
(16, 2, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.1007792754844145, 0),
(17, 2, 0, 0.9565217391304348, 0, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.20608677337826453, 0),
(18, 1, 0, 0, 1, 1, 0, 0, 0.8333333333333334, 0, 0, 0, 0.20608677337826453, 0),
(19, 4, 0, 0.9565217391304348, 0, 1, 0, 0, 0.6666666666666666, 0, 0, 0, 0.20608677337826453, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil`
--

CREATE TABLE `hasil` (
  `id` int(11) NOT NULL,
  `kategori` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `hasil`
--

INSERT INTO `hasil` (`id`, `kategori`) VALUES
(1, 'padi'),
(2, 'jagung'),
(3, 'kedelai');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwalsurvey`
--

CREATE TABLE `jadwalsurvey` (
  `idJadwal` int(11) NOT NULL,
  `jadwalsurvey` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jadwalsurvey`
--

INSERT INTO `jadwalsurvey` (`idJadwal`, `jadwalsurvey`) VALUES
(1, '2018-05-17'),
(2, '2018-05-14'),
(4, '2018-05-29');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jeniskelamin`
--

CREATE TABLE `jeniskelamin` (
  `idJK` int(11) NOT NULL,
  `jenisKelamin` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data untuk tabel `jeniskelamin`
--

INSERT INTO `jeniskelamin` (`idJK`, `jenisKelamin`) VALUES
(1, 'laki-laki'),
(2, 'perempuan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenistanah`
--

CREATE TABLE `jenistanah` (
  `id` int(11) NOT NULL,
  `jenistanah` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenistanah`
--

INSERT INTO `jenistanah` (`id`, `jenistanah`) VALUES
(1, 'aluvial'),
(2, 'androsol'),
(3, 'latosol'),
(4, 'grumosol');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kecamatan`
--

CREATE TABLE `kecamatan` (
  `idKecamatan` int(11) NOT NULL,
  `kecamatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kecamatan`
--

INSERT INTO `kecamatan` (`idKecamatan`, `kecamatan`) VALUES
(1, 'mana'),
(2, 'mini');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ketinggian`
--

CREATE TABLE `ketinggian` (
  `id` int(11) NOT NULL,
  `ketinggian` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ketinggian`
--

INSERT INTO `ketinggian` (`id`, `ketinggian`) VALUES
(1, 'dataran rendah'),
(2, 'dataran sedang'),
(3, 'dataran tinggi'),
(4, 'pegunungan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `lahankosong`
--

CREATE TABLE `lahankosong` (
  `idLK` int(11) NOT NULL,
  `pemilik` int(11) NOT NULL,
  `noTanah` varchar(13) NOT NULL,
  `alamatLK` varchar(100) NOT NULL,
  `kecamatanLK` int(11) NOT NULL,
  `desaLK` int(11) NOT NULL,
  `luas` int(11) NOT NULL,
  `statusTanah` int(11) NOT NULL DEFAULT '1',
  `jadwalsurvey` int(11) NOT NULL DEFAULT '0',
  `ketinggian` double NOT NULL DEFAULT '0',
  `luaspengairan` double NOT NULL DEFAULT '0',
  `curahhujan` double NOT NULL DEFAULT '0',
  `suhu` double NOT NULL DEFAULT '0',
  `hasil` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `lahankosong`
--

INSERT INTO `lahankosong` (`idLK`, `pemilik`, `noTanah`, `alamatLK`, `kecamatanLK`, `desaLK`, `luas`, `statusTanah`, `jadwalsurvey`, `ketinggian`, `luaspengairan`, `curahhujan`, `suhu`, `hasil`) VALUES
(1, 3, '5451', 'fcfcjg', 1, 2, 25, 5, 2, 1800, 23000, 500, 23, 'jagung'),
(2, 2, '372178', 'manamana', 1, 1, 80, 1, 2, 1500, 23000, 500, 23, 'jagung'),
(3, 4, '984', 'hdhf', 1, 1, 89, 1, 2, 0, 0, 0, 0, '0'),
(4, 4, '7898767876545', 'njdnwfn', 2, 4, 8900, 5, 2, 1500, 23000, 600, 22, 'jagung'),
(5, 4, '8767898767898', 'dbewbjh', 2, 4, 25000, 1, 0, 0, 0, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `luastanah`
--

CREATE TABLE `luastanah` (
  `id` int(11) NOT NULL,
  `kategoritanah` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `luastanah`
--

INSERT INTO `luastanah` (`id`, `kategoritanah`) VALUES
(1, 'sempit'),
(2, 'normal'),
(3, 'luas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rule`
--

CREATE TABLE `rule` (
  `idPemilik` int(11) NOT NULL,
  `ketinggian` varchar(15) NOT NULL,
  `luas` varchar(15) NOT NULL,
  `curahhujan` varchar(15) NOT NULL,
  `suhu` varchar(15) NOT NULL,
  `hasil` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rule`
--

INSERT INTO `rule` (`idPemilik`, `ketinggian`, `luas`, `curahhujan`, `suhu`, `hasil`) VALUES
(1, 'rendah', 'sempit', 'ringan', 'sedang', 'jagung'),
(2, 'sedang', 'sempit', 'ringan', 'sedang', 'jagung'),
(3, 'tinggi', 'sempit', 'ringan', 'sedang', 'jagung'),
(4, 'rendah', 'normal', 'ringan', 'sedang', 'jagung'),
(5, 'sedang', 'normal', 'ringan', 'sedang', 'jagung'),
(6, 'tinggi', 'normal', 'ringan', 'sedang', 'jagung'),
(7, 'rendah', 'luas', 'ringan', 'sedang', 'padi'),
(8, 'sedang', 'luas', 'ringan', 'sedang', 'padi'),
(9, 'tinggi', 'luas', 'ringan', 'sedang', 'padi'),
(10, 'rendah', 'sempit', 'ringan', 'panas', 'jagung'),
(11, 'sedang', 'sempit', 'ringan', 'panas', 'jagung'),
(12, 'tinggi', 'sempit', 'ringan', 'panas', 'jagung'),
(13, 'rendah', 'sempit', 'sedang', 'sedang', 'jagung'),
(14, 'sedang', 'sempit', 'sedang', 'sedang', 'jagung'),
(15, 'tinggi', 'sempit', 'sedang', 'sedang', 'jagung'),
(16, 'rendah', 'normal', 'sedang', 'sedang', 'jagung'),
(17, 'sedang', 'normal', 'sedang', 'sedang', 'jagung'),
(18, 'tinggi', 'normal', 'sedang', 'sedang', 'jagung'),
(19, 'rendah', 'luas', 'sedang', 'sedang', 'padi'),
(20, 'sedang', 'luas', 'sedang', 'sedang', 'padi'),
(21, 'tinggi', 'luas', 'sedang', 'sedang', 'padi'),
(22, 'rendah', 'sempit', 'sedang', 'panas', 'jagung'),
(23, 'sedang', 'sempit', 'sedang', 'panas', 'jagung'),
(24, 'tinggi', 'sempit', 'sedang', 'panas', 'jagung'),
(25, 'rendah', 'normal', 'sedang', 'panas', 'jagung'),
(26, 'sedang', 'normal', 'sedang', 'panas', 'jagung'),
(27, 'tinggi', 'normal', 'sedang', 'panas', 'jagung'),
(28, 'rendah', 'luas', 'sedang', 'panas', 'padi'),
(29, 'sedang', 'luas', 'sedang', 'panas', 'padi'),
(30, 'tinggi', 'luas', 'sedang', 'panas', 'padi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sinarmatahari`
--

CREATE TABLE `sinarmatahari` (
  `id` int(11) NOT NULL,
  `sinarmatahari` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `sinarmatahari`
--

INSERT INTO `sinarmatahari` (`id`, `sinarmatahari`) VALUES
(1, 'mendung'),
(2, 'panas'),
(3, ''),
(4, 'sangat panas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `spk`
--

CREATE TABLE `spk` (
  `id` int(11) NOT NULL,
  `lahanKosong` int(11) NOT NULL,
  `luaslahan` int(11) NOT NULL,
  `debitcurahhujan` int(11) NOT NULL,
  `sinarmatahari` int(11) NOT NULL,
  `ketinggian` int(11) NOT NULL,
  `hasil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `spk`
--

INSERT INTO `spk` (`id`, `lahanKosong`, `luaslahan`, `debitcurahhujan`, `sinarmatahari`, `ketinggian`, `hasil`) VALUES
(1, 2, 38, 319, 2, 8298, NULL),
(2, 3, 398, 38, 1, 82, NULL),
(3, 3, 89, 90, 3, 88, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `statustanah`
--

CREATE TABLE `statustanah` (
  `idStatus` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `statustanah`
--

INSERT INTO `statustanah` (`idStatus`, `status`) VALUES
(1, 'Proses pengajuan'),
(2, 'akan disurvey'),
(3, 'proses survey'),
(4, 'batal sewa'),
(5, 'disewa');

-- --------------------------------------------------------

--
-- Struktur dari tabel `targetlahan`
--

CREATE TABLE `targetlahan` (
  `id` int(11) NOT NULL,
  `lahan` varchar(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `targetlahan`
--

INSERT INTO `targetlahan` (`id`, `lahan`, `jumlah`) VALUES
(1, 'padi', 10),
(2, 'jagung', 25),
(3, 'kedelai', 10);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `noKTP` varchar(16) NOT NULL,
  `tempatLahir` varchar(20) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `jenisKelamin` int(11) NOT NULL,
  `noTelepon` varchar(13) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL,
  `level` enum('admin','pemilik','','') NOT NULL DEFAULT 'pemilik'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`idUser`, `nama`, `noKTP`, `tempatLahir`, `tanggalLahir`, `jenisKelamin`, `noTelepon`, `alamat`, `username`, `password`, `level`) VALUES
(1, 'dheta', '4565412365412365', '2018-05-19', '2018-05-19', 1, '081230175921', 'wqd', 'dheta', 'dheta', 'admin'),
(2, 'rhwje', '1478521478521478', '2018-05-31', '2018-05-31', 1, '0258965412541', 'efrew', 'hehe', 'hehe', 'pemilik'),
(3, 'wer', '0145236541254635', '2018-05-12', '2018-05-12', 2, '0254136541254', 'r3e', 'r3e', 'rer', 'pemilik'),
(4, 'ani', '8172654314256789', '2018-05-08', '2018-05-08', 2, '019287890987', 'sini', 'ani', 'ani', 'pemilik'),
(5, 'hihi', '1111111111111111', '1998-05-08', '1998-05-08', 1, '0981726351231', 'fds', 'hihi', 'hihi', 'pemilik'),
(6, 'wew', '0812345625142123', '1997-05-02', '1997-05-02', 1, '0812345625142', 'e', 'wiwi', 'wiwi', 'pemilik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `debitcurahhujan`
--
ALTER TABLE `debitcurahhujan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `desa`
--
ALTER TABLE `desa`
  ADD PRIMARY KEY (`idDesa`);

--
-- Indexes for table `fuzzifikasi`
--
ALTER TABLE `fuzzifikasi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hasil`
--
ALTER TABLE `hasil`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jadwalsurvey`
--
ALTER TABLE `jadwalsurvey`
  ADD PRIMARY KEY (`idJadwal`);

--
-- Indexes for table `jeniskelamin`
--
ALTER TABLE `jeniskelamin`
  ADD PRIMARY KEY (`idJK`);

--
-- Indexes for table `jenistanah`
--
ALTER TABLE `jenistanah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`idKecamatan`);

--
-- Indexes for table `ketinggian`
--
ALTER TABLE `ketinggian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lahankosong`
--
ALTER TABLE `lahankosong`
  ADD PRIMARY KEY (`idLK`),
  ADD UNIQUE KEY `noTanah` (`noTanah`);

--
-- Indexes for table `luastanah`
--
ALTER TABLE `luastanah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rule`
--
ALTER TABLE `rule`
  ADD PRIMARY KEY (`idPemilik`);

--
-- Indexes for table `sinarmatahari`
--
ALTER TABLE `sinarmatahari`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `spk`
--
ALTER TABLE `spk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `statustanah`
--
ALTER TABLE `statustanah`
  ADD PRIMARY KEY (`idStatus`);

--
-- Indexes for table `targetlahan`
--
ALTER TABLE `targetlahan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `debitcurahhujan`
--
ALTER TABLE `debitcurahhujan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `desa`
--
ALTER TABLE `desa`
  MODIFY `idDesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `fuzzifikasi`
--
ALTER TABLE `fuzzifikasi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `hasil`
--
ALTER TABLE `hasil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `jadwalsurvey`
--
ALTER TABLE `jadwalsurvey`
  MODIFY `idJadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `jeniskelamin`
--
ALTER TABLE `jeniskelamin`
  MODIFY `idJK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `jenistanah`
--
ALTER TABLE `jenistanah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `kecamatan`
--
ALTER TABLE `kecamatan`
  MODIFY `idKecamatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ketinggian`
--
ALTER TABLE `ketinggian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `lahankosong`
--
ALTER TABLE `lahankosong`
  MODIFY `idLK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `luastanah`
--
ALTER TABLE `luastanah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `rule`
--
ALTER TABLE `rule`
  MODIFY `idPemilik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `sinarmatahari`
--
ALTER TABLE `sinarmatahari`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `spk`
--
ALTER TABLE `spk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `statustanah`
--
ALTER TABLE `statustanah`
  MODIFY `idStatus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `targetlahan`
--
ALTER TABLE `targetlahan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
