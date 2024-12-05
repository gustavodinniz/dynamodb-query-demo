#!/bin/bash

echo "########### Creating profile ###########"
aws configure set aws_access_key_id default_access_key --profile=localstack
aws configure set aws_secret_access_key default_secret_key --profile=localstack
aws configure set region sa-east-1 --profile=localstack

echo "########### Setting default profile ###########"
export AWS_DEFAULT_PROFILE=localstack

echo "########### Listing profile ###########"
aws configure list

echo "########### Creating table ###########"
aws --endpoint-url=http://localhost:4566 \
      dynamodb create-table \
         --table-name Users \
         --attribute-definitions \
           AttributeName=user_id,AttributeType=S \
           AttributeName=document_id,AttributeType=S \
        --key-schema AttributeName=user_id,KeyType=HASH \
        --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
        --global-secondary-indexes \
                          "[
                              {
                                  \"IndexName\": \"documentId-index\",
                                  \"KeySchema\": [{\"AttributeName\":\"document_id\",\"KeyType\":\"HASH\"}],
                                  \"Projection\":{
                                      \"ProjectionType\":\"ALL\"
                                  },
                                  \"ProvisionedThroughput\": {
                                      \"ReadCapacityUnits\": 5,
                                      \"WriteCapacityUnits\": 5
                                  }
                              }
                          ]"

echo "########### Describing a table ###########"
aws --endpoint-url=http://localhost:4566 \
      dynamodb describe-table --table-name Users --output table

echo "########### Inserting test data into a table ###########"
aws --endpoint-url=http://localhost:4566 \
      dynamodb put-item --table-name Users --item "{\"user_id\":{\"S\":\"8a68a148-0d50-40b6-9aad-a4da512c5a43\"}, \
                                                     \"user_name\":{\"S\":\"UserTest\"}, \
                                                     \"user_type\":{\"S\":\"ADMIN\"}, \
                                                     \"document_id\":{\"S\":\"37462982021\"}}"

echo "########### Selecting all data from a table ###########"
aws --endpoint-url=http://localhost:4566 dynamodb scan --table-name Users --output table