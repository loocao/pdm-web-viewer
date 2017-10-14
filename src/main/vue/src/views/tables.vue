<template>
    <Row :gutter="16">
        <Col span="4">
        <div>
            <Input v-model="search" size="small" placeholder="filter table"></Input>
            <Tree :data="treeData" @on-select-change="selected"></Tree>
        </div>
        </Col>
        <Col span="20">
        <Table stripe size="small" :columns="columns" :data="tableData"></Table>
        </Col>
    </Row>
</template>
<script>
import util from '../libs/util'

export default {
    data: function() {
        return {
            tables: [],
            search: '',
            columns: [
                { title: '名称', key: 'name', width: 150 },
                { title: '代码', key: 'code', width: 150 },
                { title: '注释', key: 'comment' },
                { title: '默认值', key: 'defaultValue', width: 80 },
                { title: '数据类型', key: 'dataType', width: 120 },
                { title: '长度', key: 'length', width: 80 }
            ],
            selectedTable: null
        }
    },
    computed: {
        treeData: function() {
            let search = this.search

            let treeData = this.tables.filter(function(table, i) {
                return table.code.indexOf(search) > -1 || table.name.indexOf(search) > -1
            }).map(function(table) {
                return {
                    code: table.code,
                    title: `<b>${table.name}</b>`
                }
            })
            return treeData
        },
        tableData: function() {
            return this.tables.filter((table) => {
                return this.selectedTable && table.code === this.selectedTable.code
            }).map(function(table) {
                return table.columns
            })[0];
        }
    },
    watch: {
    },
    created: function() {
        util.ajax.post('/table/list').then((response) => {
            this.tables = response.data
        })
    },
    methods: {
        selected: function(nodes) {
            this.selectedTable = nodes[0]
        }
    }
}
</script>