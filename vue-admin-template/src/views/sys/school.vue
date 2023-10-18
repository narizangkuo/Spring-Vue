<template>
  <div>
    <!-- 搜索栏-->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-input v-model="schoolSearchModel.name" placeholder="学院名" />
          <el-button type="primary" plain @click="getSchoolList">查询</el-button>
        </el-col>
        <el-col :span="4" align="right">
          <el-button type="primary" icon="el-icon-plus" circle @click="openEditUI(null)" />
        </el-col>
      </el-row>
    </el-card>
    <!-- 结果栏-->
    <el-card>
      <el-table :data="schoolList" stripe style="width: 100%">
        <el-table-column prop="id" label="学院ID" width="80" />
        <el-table-column prop="name" label="学院名称" width="180" />
        <el-table-column prop="createTime" label="创办时间" width="300" />
        <el-table-column prop="description" label="学院简介" width="600" />
        <el-table-column prop="updateTime" label="更新时间" width="600" />
        <el-table-column label="操作" fixed="right" width="100">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" size="mini" circle @click="openEditUI(scope.row.id)" />
            <el-button type="danger" icon="el-icon-delete" size="mini" circle @click="deleteSchoolById(scope.row)" />
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!--分页-->
    <!--<el-pagination
      :current-page="schoolSearchModel.pageNo"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="schoolSearchModel.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />-->
    <!--学院信息编辑对话框-->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form ref="schoolFormRef" :model="schoolForm" :rules="rules">
        <el-form-item label="学院名称" prop="name" :label-width="formLabelWidth">
          <el-input v-model="schoolForm.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="创办时间" prop="createTime" :label-width="formLabelWidth">
          <el-date-picker v-model="schoolForm.createTime" prop="date" type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="学院简介" prop="description" :label-width="formLabelWidth">
          <el-input v-model="schoolForm.description" autocomplete="off" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveSchool">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import schoolApi from '@/api/school'
export default {
  data() {
    return {
      formLabelWidth: '130px',
      schoolForm: {},
      dialogFormVisible: false,
      title: '',
      total: 0,
      schoolSearchModel: {
        pageNo: 1,
        pageSize: 10
      },
      schoolList: [],
      rules: {
        name: [
          { required: true, message: '请输入学院名称', trigger: 'blur' },
          { min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: '请选择学院创办日期', trigger: 'change' }
        ],
        description: [
          { required: true, message: '请输入学院简介', trigger: 'blur' },
          { min: 3, max: 1024, message: '长度在 3 到 1024 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getSchoolList()
  },
  methods: {
    deleteSchoolById(school) {
      this.$confirm(`您确认删除学院 ${school.name} ?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        schoolApi.deleteSchoolById(school.id).then(response => {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.getSchoolList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    saveSchool() {
      // 触发表单验证
      this.$refs.schoolFormRef.validate((valid) => {
        if (valid) {
          // 提交请求给后台
          schoolApi.saveSchool(this.schoolForm).then(response => {
            // 成功提示
            this.$message({
              message: response.message,
              type: 'success'
            })
            // 关闭对话框
            this.dialogFormVisible = false
            // 刷新表单
            this.getSchoolList()
          }
          )
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    clearForm() {
      this.schoolForm = {}
      this.$refs.schoolFormRef.clearValidate()
    },
    openEditUI(id) {
      if (id == null) {
        this.title = '新增学院'
      } else {
        this.title = '修改学院'
        schoolApi.getSchoolById(id).then(response => { this.schoolForm = response.data })
      }
      this.dialogFormVisible = true
    },
    handleSizeChange() {

    },
    handleCurrentChange() {

    },
    getSchoolList() {
      schoolApi.getSchoolList(this.schoolSearchModel).then(response => {
        this.schoolList = response.data.rows
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
@/api/school
