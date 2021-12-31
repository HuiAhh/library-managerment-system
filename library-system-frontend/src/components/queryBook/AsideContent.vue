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
        <el-menu-item index="/query">普通查询
        </el-menu-item>
        <el-menu-item index="/query/advance">高级查询
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "AsideContent",
        props: ['mode'],
        data() {
            return {
                activeIndex: '/query'
            }
        }
    }
</script>

<style scoped>

</style>