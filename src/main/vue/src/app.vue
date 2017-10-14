<template>
    <div class="layout">
        <Menu mode="horizontal" :theme="theme" active-name="1">
            <Submenu name="1">
                <template slot="title">
                    菜单
                </template>
                <MenuItem name="1-1">打开</MenuItem>
            </Submenu>
            <MenuItem name="2">关于</MenuItem>
        </Menu>

        <div class="layout-content">
            <router-view></router-view>
        </div>

    </div>
</template>

<style scoped>
.layout {
    padding: 0 20px;
}

.layout-content {
    min-height: 200px;
    margin: 15px;
    overflow: hidden;
    border-radius: 4px;
}
</style>


<script>
export default {
    data() {
        return {
            theme: 'light'
        };
    },
    mounted() {

    },
    beforeDestroy() {

    },
    methods: {

    }
};
</script>