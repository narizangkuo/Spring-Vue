import request from '@/utils/request'

export default {
  getStudentList(studentSearchModel) {
    console.log('zack 查询类型' + studentSearchModel.searchType)
    console.log('zack 查询内容' + studentSearchModel.searchContent)
    return request({
      url: '/student/list',
      method: 'get',
      params: {
        searchType: studentSearchModel.searchType,
        searchContent: studentSearchModel.searchContent
      }
    })
  },
  getStudentList2() {
    return request({
      url: '/student/list',
      method: 'get',
      params: {}
    })
  },
  addStudent(student) {
    return request({
      url: '/student/add_student',
      method: 'post',
      data: student,
      params: student
    })
  },
  updateStudent(student) {
    return request({
      url: '/student/update_student',
      method: 'put',
      data: student,
      params: student
    })
  },
  saveStudent(student) {
    if (student.id === null || student.id === undefined) {
      return this.addStudent(student)
    }
    return this.updateStudent(student)
  },
  getStudentById(id) {
    return request({
      url: `/student/${id}`,
      method: 'get'
    })
  },
  deleteStudentById(id) {
    return request({
      url: `/student/${id}`,
      method: 'delete'
    })
  },
  test(studentForm, majorId, schoolId) {
    console.log('外部专业id' + majorId)
    console.log('外部学院id' + schoolId)
    console.log('专业id' + studentForm.major.id)
    console.log('学院id' + studentForm.school.id)
  },
  saveStudent2(student, majorId, schoolId, majorList, schoolList, flag) {
    // console.log('zangkuo in saveStudent2 majorId= ' + majorId + 'schoolId=' + schoolId)
    // console.log('majorList :' + majorList)
    // console.log('schoolList' + schoolList)
    for (var major of majorList) {
      // console.log('in majorList major.id = ' + major.id)
      if (major.id === majorId) {
        student.major = major
        break
      }
    }
    for (var school of schoolList) {
      // console.log('in schoolList school id =' + school.id)
      if (school.id === schoolId) {
        student.school = school
        break
      }
    }
    if (flag === false) {
      return this.addStudent(student)
    }
    return this.updateStudent(student)
  }
}
