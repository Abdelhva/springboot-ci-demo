import {createRouter, createWebHistory} from 'vue-router'
import usersView from '../views/UsersView.vue'
import MakeNewUser from "../views/MakeNewUser.vue";

const routes = [
    { path: '/users', component: usersView},
    {path: '/users/makeuser', component: MakeNewUser}
]

export default createRouter({
    history: createWebHistory(),
    routes
})