<template>
  <div>
    <!-- 搜索栏-->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-input v-model="majorSearchModel.name" placeholder="专业名" />
          <el-button type="primary" plain @click="getMajorList">查询</el-button>
        </el-col>
        <el-col :span="4" align="right">
          <el-button type="primary" icon="el-icon-plus" circle @click="openEditUI(null)" />
        </el-col>
      </el-row>
    </el-card>
    <!-- 结果栏-->
    <el-card>
      <el-table :data="majorList" stripe style="width: 100%">
        <el-table-column prop="id" label="专业ID" width="80" />
        <el-table-column prop="name" label="专业名称" width="180" />
        <el-table-column prop="createTime" label="创办时间" width="300" />
        <el-table-column prop="description" label="专业简介" width="600" />
        <el-table-column prop="updateTime" label="更新时间" width="600" />
        <el-table-column label="操作" fixed="right" width="100">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" size="mini" circle @click="openEditUI(scope.row.id)" />
            <el-button type="danger" icon="el-icon-delete" size="mini" circle @click="deleteMajorById(scope.row)" />
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!--分页-->
    <!--<el-pagination
      :current-page="majorSearchModel.pageNo"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="majorSearchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />-->
    <!--专业信息编辑对话框-->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form ref="majorFormRef" :model="majorForm" :rules="rules">
        <el-form-item label="专业名称" prop="name" :label-width="formLabelWidth">
          <el-input v-model="majorForm.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="创办时间" prop="createTime" :label-width="formLabelWidth">
          <el-date-picker v-model="majorForm.createTime" prop="date" type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="专业简介" prop="description" :label-width="formLabelWidth">
          <el-input v-model="majorForm.description" autocomplete="off" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveMajor">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import majorApi from '@/api/major'
export default {
  data() {
    return {
      formLabelWidth: '130px',
      majorForm: {},
      dialogFormVisible: false,
      title: '',
      total: 0,
      majorSearchModel: {
        pageNo: 1,
        pageSize: 10
      },
      majorList: [],
      rules: {
        name: [
          { required: true, message: '请输入专业名称', trigger: 'blur' },
          { min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: '请选择专业创办日期', trigger: 'change' }
        ],
        description: [
          { required: true, message: '请输入专业简介', trigger: 'blur' },
          { min: 3, max: 1024, message: '长度在 3 到 1024 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getMajorList()
  },
  methods: {
    deleteMajorById(major) {
      this.$confirm(`您确认删除专业 ${major.name} ?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        majorApi.deleteMajorById(major.id).then(response => {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.getMajorList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    saveMajor() {
      // 触发表单验证
      this.$refs.majorFormRef.validate((valid) => {
        if (valid) {
          // 提交请求给后台
          majorApi.saveMajor(this.majorForm).then(response => {
            // 成功提示
            this.$message({
              message: response.message,
              type: 'success'
            })
            // 关闭对话框
            this.dialogFormVisible = false
            // 刷新表单
            this.getMajorList()
          }
          )
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    clearForm() {
      this.majorForm = {}
      this.$refs.majorFormRef.clearValidate()
    },
    openEditUI(id) {
      if (id == null) {
        this.title = '新增专业'
      } else {
        this.title = '修改专业'
        majorApi.getMajorById(id).then(response => { this.majorForm = response.data })
      }
      this.dialogFormVisible = true
    },
    handleSizeChange() {

    },
    handleCurrentChange() {

    },
    getMajorList() {
      majorApi.getMajorList(this.majorSearchModel).then(response => {
        this.majorList = response.data.rows
        this.total = response.data.total
      })
    }
  }
}
</script>

<style>
#search .el-input {
  width: 200px;
  margin-right: 10px;
}

.el-dialog .el-input {
  width: 85%;
}
</style>
@/api/major
