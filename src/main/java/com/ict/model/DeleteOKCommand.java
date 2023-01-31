package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;

public class DeleteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String cPage = request.getParameter("cPage");
		String b_idx = request.getParameter("b_idx");
		
		// 방법 1 : 원글에 속한 댓글 모두 삭제
		
		// 댓글 삭제
		int res = DAO.getCommentDelete(b_idx);
		
		// 원글삭제	
		try {
			int result = DAO.getDelete(b_idx);
		} catch (Exception e) {
			return "view/error.jsp";
		}
		
		
		// 방법 2 
		// 원글에 관련된 댓글이 있으면 오류 발생한다.(삭제 안됨)
		//try {
		//	int result = DAO.getDelete(b_idx);
		//} catch (Exception e) {
		//	return "view/error.jsp";
		//}
		return "MyController?cmd=list&cPage="+cPage;
	}

}
