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
        <el-menu-item index="/borrow">借书
        </el-menu-item>
        <el-menu-item index="/borrow/return">还书
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "AsideContent",
        data() {
            return {
                activeIndex: '/borrow'
            }
        }
    }
</script>

<style scoped>

</style>