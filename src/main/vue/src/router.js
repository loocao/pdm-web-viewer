const routers = [{
    path: '/',
    meta: {
        title: ''
    },
    component: (resolve) => require(['./views/index.vue'], resolve)
}, {
    path: '/tables',
    meta: {
        title: '表格预览'
    },
    component: (resolve) => require(['./views/tables.vue'], resolve)
}];
export default routers;