<template>
    <div>
        <h2 class="page-title">
            普通查询
        </h2>
        <el-form class="page-form" label-position="left" label-width="80px">
            <el-form-item label="书名">
                <el-input placeholder="查询图书"
                          v-model="form.name"
                          clearable>
                    <i slot="prefix" class="el-input__icon el-icon-search"
                    ></i>
                    <el-button slot="append" icon="el-icon-search" @click="queryBook"></el-button>
                </el-input>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "SingleQuery",
        data() {
            return {
                form: {
                    name: ''
                }
            }
        }, methods: {
            queryBook() {
                let self = this
                let url = '/book'
                axios.get(url,
                    {
                        params: this.form
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

</style>