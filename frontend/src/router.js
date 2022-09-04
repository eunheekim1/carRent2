
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CarRentManager from "./components/listers/CarRentCards"
import CarRentDetail from "./components/listers/CarRentDetail"

import CarMgmtManager from "./components/listers/CarMgmtCards"
import CarMgmtDetail from "./components/listers/CarMgmtDetail"


import TotalCarListView from "./components/TotalCarListView"
import TotalCarListViewDetail from "./components/TotalCarListViewDetail"
import MemberMgmtManager from "./components/listers/MemberMgmtCards"
import MemberMgmtDetail from "./components/listers/MemberMgmtDetail"

import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/carRents',
                name: 'CarRentManager',
                component: CarRentManager
            },
            {
                path: '/carRents/:id',
                name: 'CarRentDetail',
                component: CarRentDetail
            },

            {
                path: '/carMgmts',
                name: 'CarMgmtManager',
                component: CarMgmtManager
            },
            {
                path: '/carMgmts/:id',
                name: 'CarMgmtDetail',
                component: CarMgmtDetail
            },


            {
                path: '/totalCarLists',
                name: 'TotalCarListView',
                component: TotalCarListView
            },
            {
                path: '/totalCarLists/:id',
                name: 'TotalCarListViewDetail',
                component: TotalCarListViewDetail
            },
            {
                path: '/memberMgmts',
                name: 'MemberMgmtManager',
                component: MemberMgmtManager
            },
            {
                path: '/memberMgmts/:id',
                name: 'MemberMgmtDetail',
                component: MemberMgmtDetail
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },



    ]
})
