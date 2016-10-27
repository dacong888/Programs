package com.task08.dataformat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.task08.user.Employee;

/**
 * JSON解析接口实现
 */
public class JsonOutputHelper implements IOutputHelper {

	@Override
	public String outputHelper(Employee employees) {

		// 生成一个json对象
		JSONObject json = new JSONObject();

		try {
			// add id
			json.put("id", employees.getId());

			// add name
			json.put("name", employees.getName());

			// add gender
			json.put("gender", employees.getGender());

			// add age
			json.put("age", employees.getAge());

			// add phoneCall
			json.put("phonecall", employees.getPhoneCall());

			// add address
			json.put("address", employees.getAddress());

			JSONArray jsonArray = new JSONArray();
			jsonArray.put(json);

			// 输出结果
			return jsonArray.toString();

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}
}
