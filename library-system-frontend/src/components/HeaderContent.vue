<template>
    <el-row align="bottom" justify="bottom">
        <el-col :span="8">
            <table class="page-logo">
                <tr>
                    <td><i class="el-icon-reading"></i></td>
                    <td><h1>XX图书馆</h1></td>
                </tr>
            </table>
        </el-col>
        <el-col :span="10">
            <HeaderLink/>
        </el-col>
        <el-col :span="6">
            <el-input
                    placeholder="查询图书"
                    v-model="searchBook"
                    clearable>
                <i slot="prefix" class="el-input__icon el-icon-search"></i>
                <el-button slot="append" icon="el-icon-search" @click="queryResult"></el-button>
            </el-input>
        </el-col>
    </el-row>
</template>

<script>
    import HeaderLink from "./HeaderLink";
    import axios from "axios";

    export default {
        name: "HeaderContent",
        components: {HeaderLink},
        data() {
            return {
                searchBook: ''
            }
        }, methods: {
            queryResult() {
                let self = this
                let url = '/book'
                axios.get(url,
                    {
                        params: {
                            name: this.searchBook
                        }
                    }
                ).then(function (response) {
                    if (response['status'] === 200) {
                        let data = response['data']
                        self.$store.commit('putBookQueryResult', data)
                        self.$router.push('/result')
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .page-logo {
        margin-top: -15px;
        font-size: 20px;
    }
</style>