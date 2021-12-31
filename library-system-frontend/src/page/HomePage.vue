<template>
    <el-container>
        <el-aside class="page-aside hidden-sm-and-down" width="150px">
            <AsideContent mode="vertical"/>
        </el-aside>
        <el-container>
            <el-header class="page-header" height="45px">
                <HeaderContent/>
            </el-header>
            <el-header class="page-aside hidden-md-and-up">
                <AsideContent mode="horizontal"/>
            </el-header>
            <el-main class="page-main">
                <router-view/>
            </el-main>
            <el-footer class="page-footer">
                <p class="page-copyright">
                    Copyright © 2020 Weng. All rights reserved.
                </p>
            </el-footer>
        </el-container>
    </el-container>
</template>
<script>
    import AsideContent from "../components/homePage/AsideContent"
    import HeaderContent from "../components/HeaderContent"

    export default {
        name: 'HomePage',
        components: {AsideContent, HeaderContent}
    }
</script>
<style>

</style>