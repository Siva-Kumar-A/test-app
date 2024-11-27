# API Documentation

## Overview

This document provides information about the available API endpoints for our application.

## Endpoints

### Echo Endpoint

- **URL:** `/api/echo`
- **Method:** `POST`
- **Description:** This endpoint echoes back the JSON payload sent to it.
- **Request Body:**
  ```json
  {
    "RecordType": "xxx",
    "DeviceId": "357370040159770",
    "EventDateTime": "2014-05-12T05:09:48Z",
    "FieldA": 68,
    "FieldB": "xxx",
    "FieldC": 123.45
  }
  ```
- **Response Status:** `200 OK`
- **Response Body:** The same JSON payload sent in the request.

### Get Record by ID

- **URL:** `/id/{id}`
- **Method:** `GET`
- **Description:** This endpoint retrieves a record by its ID.
- **Path Parameter:**
  - `id`: The unique identifier of the record.
- **Request Headers:**
  - `Content-Type: application/json`
- **Response Status:** `200 OK`
- **Response Body:**
  ```json
  {
    "id": "{id}",
    // Other record fields
  }
  ```

## Example Usage

### POST `/api/echo`

**Request:**
```bash
curl -X POST "http://localhost:8080/api/echo" -H "Content-Type: application/json" -d '{
    "RecordType": "xxx",
    "DeviceId": "357370040159770",
    "EventDateTime": "2014-05-12T05:09:48Z",
    "FieldA": 68,
    "FieldB": "xxx",
    "FieldC": 123.45
}'
```

**Response:**
```json
{
    "RecordType": "xxx",
    "DeviceId": "357370040159770",
    "EventDateTime": "2014-05-12T05:09:48Z",
    "FieldA": 68,
    "FieldB": "xxx",
    "FieldC": 123.45
}
```

### GET `/id/{id}`

**Request:**
```bash
curl -X GET "http://localhost:8080/id/123" -H "Content-Type: application/json"
```

**Response:**
```json
{
    "id": "123",
    // Other record fields
}
```
