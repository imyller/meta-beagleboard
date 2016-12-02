require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE ?= "zImage"

COMPATIBLE_MACHINE = "(beaglebone)"

FILESPATH =. "${FILE_DIRNAME}/linux-beagleboard-4.9:${FILE_DIRNAME}/linux-beagleboard-4.9/${MACHINE}:"

S = "${WORKDIR}/git"

PV = "4.9.0-rc7"

SRC_URI = "git://github.com/beagleboard/linux.git;branch=4.9;nobranch=1"
SRCREV_pn-${PN} = "13437cd99c714bcb12c0f0bfd6c6713675c02386"

SRC_URI += " \
	file://defconfig \
	file://logo_linux_clut224.ppm \
"

KERNEL_DEVICETREE = "am335x-bone.dtb am335x-boneblack.dtb am335x-bonegreen.dtb am335x-boneblue.dtb am335x-sancloud-bbe.dtb"

KERNEL_CC_append = " -fuse-ld=bfd"

PACKAGES =+ "kernel-dbg"
FILES_kernel-dbg += "/usr/src/kernel/firmware/.debug/"
