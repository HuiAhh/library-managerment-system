<template>
    <el-menu
            :default-active="activeIndex"
            class="aside"
            mode="horizontal"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            router
    >
        <el-menu-item index="/">图书馆介绍
        </el-menu-item>
        <el-menu-item index="/location">地理位置
        </el-menu-item>
        <el-menu-item index="/about-books">
            关于藏书
        </el-menu-item>
        <el-menu-item index="/contact-us">
            联系我们
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "AsideContent",
        props: ['mode'],
        data() {
            return {
                activeIndex: '/'
            }
        }
    }
</script>

<style scoped>

</style>