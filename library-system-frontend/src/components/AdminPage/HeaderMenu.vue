<template>
    <el-menu :default-active="activeIndex" mode="horizontal" router>
        <el-menu-item index="/admin">用户注册</el-menu-item>
        <el-submenu index="/admin/book">
            <template slot="title">图书管理</template>
            <el-menu-item index="/admin/book">图书概览</el-menu-item>
            <el-menu-item index="/admin/book/input">图书入库</el-menu-item>
            <el-menu-item index="/admin/book/query">查询图书</el-menu-item>
        </el-submenu>
        <el-submenu index="/admin/user">
            <template slot="title">用户管理</template>
            <el-menu-item index="/admin/user">用户概览</el-menu-item>
            <el-menu-item index="/admin/user/blocklist">黑名单</el-menu-item>
            <el-menu-item index="/admin/user/query">用户查询</el-menu-item>
        </el-submenu>
        <el-submenu index="/admin/borrow">
            <template slot="title">借还管理</template>
            <el-menu-item index="/admin/borrow">借还记录</el-menu-item>
            <el-menu-item index="/admin/borrow/query">精确查询</el-menu-item>
        </el-submenu>
    </el-menu>
</template>

<script>
    export default {
        name: "HeaderMenu",
        data() {
            return {
                activeIndex: '/admin'
            }
        }
    }
</script>

<style scoped>

</style>