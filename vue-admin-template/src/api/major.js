import request from '@/utils/request'

export default {
  getMajorList(majorSearchModel) {
    console.log('获取数据')
    return request({
      url: '/major/list',
      method: 'get',
      params: {
        // pageNo: majorSearchModel.pageNo,
        // pageSize: majorSearchModel.pageSize,
        name: majorSearchModel.name,
        create_time: majorSearchModel.create_time
      }
    })
  },
  addMajor(major) {
    return request({
      url: '/major/add_major',
      method: 'post',
      data: major,
      params: major
    })
  },
  updateMajor(major) {
    return request({
      url: '/major/update_major',
      method: 'put',
      data: major,
      params: major
    })
  },
  saveMajor(major) {
    if (major.id === null || major.id === undefined) {
      return this.addMajor(major)
    }
    return this.updateMajor(major)
  },
  getMajorById(id) {
    return request({
      url: `/major/${id}`,
      method: 'get'
    })
  },
  deleteMajorById(id) {
    return request({
      url: `/major/${id}`,
      method: 'delete'
    })
  }
}
