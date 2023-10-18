import request from '@/utils/request'

export default {
  getSchoolList(searchModel) {
    return request({
      url: '/school/list',
      method: 'get',
      params: {
        // pageNo: searchModel.pageNo,
        // pageSize: searchModel.pageSize,
        name: searchModel.name,
        create_time: searchModel.create_time
      }
    })
  },
  addSchool(school) {
    return request({
      url: '/school/add_school',
      method: 'post',
      data: school,
      params: school
    })
  },
  updateSchool(school) {
    return request({
      url: '/school/update_school',
      method: 'put',
      data: school,
      params: school
    })
  },
  saveSchool(school) {
    if (school.id === null || school.id === undefined) {
      return this.addSchool(school)
    }
    console.log('修改学院数据')
    return this.updateSchool(school)
  },
  getSchoolById(id) {
    return request({
      url: `/school/${id}`,
      method: 'get'
    })
  },
  deleteSchoolById(id) {
    return request({
      url: `/school/${id}`,
      method: 'delete'
    })
  }
}
