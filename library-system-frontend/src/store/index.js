import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        bookQueryResult: {},
        userQueryResult: {},
        borrowParameter:{}
    },
    mutations: {
        putBorrowParameter(state,data){
            state.borrowParameter=data
        },
        putBookQueryResult(state, data) {
            state.bookQueryResult = data
        },
        putUserQueryResult(state, data) {
            state.userQueryResult = data
        }
    }
})