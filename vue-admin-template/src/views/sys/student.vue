<template>
  <div>
    <!-- 搜索栏-->
    <el-card id="search">
      <el-row>
        <el-col :span="20">
          <el-button type="info" disabled>请选择查询条件，默认查询所有</el-button>
          <el-select v-model="studentSearchModel.searchType" filterable placeholder="请选择">
            <el-option v-for="item in searchOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
          <el-input v-model="studentSearchModel.searchContent" placeholder="请输入" />
          <el-button type="primary" plain @click="getStudentList">查询</el-button>
        </el-col>

        <el-col :span="4" align="right">
          <el-button type="primary" icon="el-icon-plus" circle @click="openEditUI(null)" />
        </el-col>
      </el-row>
    </el-card>
    <!-- 结果栏-->
    <el-card>
      <el-table :data="studentList" stripe style="width: 100%">
        <el-table-column prop="id" label="学号" width="180" />
        <el-table-column prop="name" label="姓名" width="100" />
        <el-table-column prop="idCard" label="身份证" width="300" />
        <el-table-column prop="sex" label="性别" :formatter="sexFormate" width="60" />
        <el-table-column prop="sClass" label="班级" :formatter="classFormate" width="60" />
        <el-table-column prop="sType" label="类型" :formatter="typeFormate" width="100" />
        <el-table-column prop="rollTime" label="入学时间" width="150" />
        <el-table-column prop="mobile" label="联系方式" width="300" />
        <el-table-column prop="major.name" label="专业" width="180" />
        <el-table-column prop="school.name" label="学院" width="180" />
        <el-table-column prop="updateTime" label="更新时间" width="150" />
        <el-table-column label="操作" fixed="right" width="100">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" size="mini" circle @click="openEditUI(scope.row)" />
            <el-button type="danger" icon="el-icon-delete" size="mini" circle @click="deleteStudentById(scope.row)" />
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!--弹框表单-->
    <el-dialog :title="title" :visible.sync="dialogFormVisible" @close="clearForm">
      <el-form ref="studentFormRef" :model="studentForm" :rules="rules">
        <el-form-item label="学号" prop="id" :label-width="formLabelWidth">
          <el-input v-model.number="studentForm.id" autocomplete="off" :disabled="modifyStudentFlag" />
        </el-form-item>
        <el-form-item label="姓名" prop="name" :label-width="formLabelWidth">
          <el-input v-model="studentForm.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="身份证" prop="idCard" :label-width="formLabelWidth">
          <el-input v-model="studentForm.idCard" autocomplete="off" />
        </el-form-item>
        <el-form-item label="性别" prop="sex" :label-width="formLabelWidth">
          <el-select v-model="studentForm.sex" filterable placeholder="请选择">
            <el-option v-for="item in sexOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="班级" prop="sClass" :label-width="formLabelWidth">
          <el-select v-model="studentForm.sClass" filterable placeholder="请选择">
            <el-option v-for="item in classOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="类型" prop="sType" :label-width="formLabelWidth">
          <el-select v-model="studentForm.sType" filterable placeholder="请选择">
            <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="入学时间" prop="rollTime" :label-width="formLabelWidth">
          <el-date-picker v-model="studentForm.rollTime" prop="date" type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="联系方式" prop="mobile" :label-width="formLabelWidth">
          <el-input v-model="studentForm.mobile" autocomplete="off" />
        </el-form-item>
        <el-form-item label="专业" prop="major" :label-width="formLabelWidth">
          <el-select v-model="majorId" filterable placeholder="请选择">
            <el-option v-for="item in majorList" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="学院" prop="school" :label-width="formLabelWidth">
          <el-select v-model="schoolId" filterable placeholder="请选择">
            <el-option v-for="item in schoolList" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveStudent">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import studentApi from '@/api/student'
import schoolApi from '@/api/school'
import majorApi from '@/api/major'
export default {
  data() {
    return {
      sexOptions: [
        {
          value: 0,
          label: '男'
        }, {
          value: 1,
          label: '女'
        }
      ],
      classOptions: [
        {
          value: 1,
          label: '一班'
        }, {
          value: 2,
          label: '二班'
        },
        {
          value: 3,
          label: '三班'
        }, {
          value: 4,
          label: '四班'
        },
        {
          value: 5,
          label: '五班'
        }, {
          value: 6,
          label: '六班'
        }
      ],
      typeOptions: [
        {
          value: 1,
          label: '本科生'
        }, {
          value: 2,
          label: '研究生'
        }, {
          value: 3,
          label: '博士生'
        }
      ],
      modifyStudentFlag: false,
      title: '',
      searchOptions: [{
        value: 0,
        label: '全部'
      }, {
        value: 1,
        label: '姓名'
      }, {
        value: 2,
        label: '学号'
      }, {
        value: 3,
        label: '专业'
      }, {
        value: 4,
        label: '学院'
      }, {
        value: 5,
        label: '类型'
      }],
      formLabelWidth: '130px',
      studentForm: {
        major: {
          name: ''
        },
        school: {
          name: ''
        }
      },
      dialogFormVisible: false,
      studentSearchModel: {
        searchType: 0,
        searchContent: ''
      },
      majorSearchModel: {
        name: '',
        create_time: ''
      },
      schoolSearchModel: {
        name: '',
        create_time: ''
      },
      studentList: [],
      schoolList: [],
      majorList: [],
      schoolId: '',
      majorId: '',
      rules: {
        id: [
          { required: true, message: '请输入学生学号', trigger: 'blur' },
          { type: 'number', message: '学号必须为数字值' }
        ],
        name: [
          { required: true, message: '请输入学生姓名', trigger: 'blur' },
          { min: 2, max: 20, message: '姓名在 2 到 50 个字符', trigger: 'blur' }
        ],
        idCard: [
          { required: true, message: '请输入身份证号', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'blur' }
        ],
        sClass: [
          { required: true, message: '请选择班级', trigger: 'blur' }
        ],
        sType: [
          { required: true, message: '请选择学生类型', trigger: 'blur' }
        ],
        rollTime: [
          { required: true, message: '请选择入学时间', trigger: 'blur' }
        ],
        mobile: [
          { required: true, message: '请填写联系方式', trigger: 'blur' }
        ],
        major: [
          { required: true, message: '请选择专业创办日期', trigger: 'change' }
        ],
        school: [
          { required: true, message: '请输入专业简介', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getStudentList()
    this.getMajorList()
    this.getSchoolList()
  },
  methods: {
    deleteStudentById(student) {
      this.$confirm(`您确认删除专业 ${student.name} ?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        studentApi.deleteStudentById(student.id).then(response => {
          this.$message({
            type: 'success',
            message: response.message
          })
          this.getStudentList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    saveStudent() {
      // 触发表单验证
      this.$refs.studentFormRef.validate((valid) => {
        if (valid) {
          this.studentForm.majorId = this.majorId
          this.studentForm.schoolId = this.schoolId
          studentApi.test(this.studentForm, this.studentForm.majorId, this.studentForm.schoolId)
          // 提交请求给后台
          studentApi.saveStudent2(this.studentForm, this.majorId, this.schoolId, this.majorList, this.schoolList, this.modifyStudentFlag).then(response => {
            // 成功提示
            this.$message({
              message: response.message,
              type: 'success'
            })
            // 关闭对话框
            this.dialogFormVisible = false
            // 刷新表单
            this.getStudentList()
          }
          )
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    clearForm() {
      this.studentForm = {
        major: {
          name: ''
        },
        school: {
          name: ''
        }
      }
      this.majorId = ''
      this.schoolId = ''
      this.$refs.studentFormRef.clearValidate()
    },
    openEditUI(scope) {
      if (scope == null) {
        this.title = '新增学生'
        this.modifyStudentFlag = false
      } else {
        this.title = '修改学生'
        this.majorId = scope.major.id
        this.schoolId = scope.school.id
        this.modifyStudentFlag = true
        studentApi.getStudentById(scope.id).then(response => { this.studentForm = response.data })
      }
      this.dialogFormVisible = true
    },
    handleSizeChange() {

    },
    handleCurrentChange() {

    },
    getStudentList() {
      studentApi.getStudentList(this.studentSearchModel).then(response => {
        this.studentList = response.data.rows
        // this.total = response.data.total
      })
    },
    getMajorList() {
      majorApi.getMajorList(this.majorSearchModel).then(response => {
        this.majorList = response.data.rows
        // this.total = response.data.total
      })
    },
    getSchoolList() {
      schoolApi.getSchoolList(this.schoolSearchModel).then(response => {
        this.schoolList = response.data.rows
        // this.total = response.data.total
      })
    },
    sexFormate(row, index) {
      if (row.sex === 1) {
        return '女'
      } else if (row.sex === 0) {
        return '男'
      } else {
        return ''
      }
    },
    typeFormate(row, index) {
      if (row.sType === 1) {
        return '本科生'
      } else if (row.sType === 2) {
        return '研究生'
      } else if (row.sType === 3) {
        return '博士生'
      } else {
        return ''
      }
    },
    classFormate(row, index) {
      if (row.sClass === 1) {
        return '一班'
      } else if (row.sClass === 2) {
        return '二班'
      } else if (row.sClass === 3) {
        return '三班'
      } else if (row.sClass === 4) {
        return '四班'
      } else if (row.sClass === 5) {
        return '五班'
      } else if (row.sClass === 6) {
        return '六班'
      } else {
        return ''
      }
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
@/api/student
