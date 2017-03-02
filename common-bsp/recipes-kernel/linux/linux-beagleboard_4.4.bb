require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(beaglebone)"

FILESPATH =. "${FILE_DIRNAME}/linux-beagleboard-4.4:${FILE_DIRNAME}/linux-beagleboard-4.4/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "4.4.52"

SRC_URI = "git://github.com/beagleboard/linux.git;branch=4.4;nobranch=1"
SRCREV_pn-${PN} = "21fb1597f3fdf6a17d509b98ddf3d71475967fdb"

SRC_URI += " \
	file://defconfig \
	file://logo_linux_clut224.ppm \
"

KERNEL_DEVICETREE = "am335x-bone.dtb am335x-boneblack.dtb am335x-bonegreen.dtb"

KERNEL_CC_append = " -fuse-ld=bfd"

PACKAGES =+ "kernel-dbg"
FILES_kernel-dbg += "/usr/src/kernel/firmware/.debug/"
