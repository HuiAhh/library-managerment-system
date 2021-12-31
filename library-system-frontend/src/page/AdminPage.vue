<template>
    <div>
        <HeaderMenu/>
        <router-view/>
    </div>
</template>

<script>
    import HeaderMenu from "../components/AdminPage/HeaderMenu";

    export default {
        name: "AdminPage",
        components: {HeaderMenu}
    }
</script>

<style scoped>

</style>