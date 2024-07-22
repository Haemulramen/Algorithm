#include <iostream>

using namespace std;

int N, common = 0, uncommon = 0;
static char map[100][100];

int xpos[4] = { 1, 0, -1, 0 };
int ypos[4] = { 0, 1, 0, -1 };

void dfs(int x, int y);
void dfs_uncommon(int x, int y);

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 'R' || map[i][j] == 'G' || map[i][j] == 'B') {
				dfs(i, j);
				common++;
			}
		}
	}
	cout << common << '\n';

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == 'r' || map[i][j] == 'g' || map[i][j] == 'b') {
				dfs_uncommon(i, j);
				uncommon++;
			}
		}
	}
	cout << uncommon;

	return 0;
}

void dfs(int x, int y) {
	map[x][y] = map[x][y] + 32;	
	for (int i = 0; i < 4; i++) {
		if (x + xpos[i] < 0 || x + xpos[i] >= N || y + ypos[i] < 0 || y + ypos[i] >= N) {
			continue;
		}
		if (map[x + xpos[i]][y + ypos[i]] + 32 == map[x][y]) {
			dfs(x + xpos[i], y + ypos[i]);
		}
	}
}

void dfs_uncommon(int x, int y) {
	map[x][y] = map[x][y] - 32;
	for (int i = 0; i < 4; i++) {
		if (x + xpos[i] < 0 || x + xpos[i] >= N || y + ypos[i] < 0 || y + ypos[i] >= N) {
			continue;
		}
		if (map[x][y] == 'R' || map[x][y] == 'G') {
			if (map[x + xpos[i]][y + ypos[i]] == 'r' || map[x + xpos[i]][y + ypos[i]] == 'g') {
				dfs_uncommon(x + xpos[i], y + ypos[i]);
			}
		}
		else if (map[x + xpos[i]][y + ypos[i]] - 32 == map[x][y]) {
			dfs_uncommon(x + xpos[i], y + ypos[i]);
		}
	}
}